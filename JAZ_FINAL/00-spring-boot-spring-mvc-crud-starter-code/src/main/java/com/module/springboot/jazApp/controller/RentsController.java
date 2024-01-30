    package com.module.springboot.jazApp.controller;
    import com.module.springboot.jazApp.DTO.RentDTO;
    import com.module.springboot.jazApp.entity.Book;
    import com.module.springboot.jazApp.entity.Rents;
    import com.module.springboot.jazApp.entity.Student;
    import com.module.springboot.jazApp.service.BookService;
    import com.module.springboot.jazApp.service.RentsService;
    import com.module.springboot.jazApp.service.StudentService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.*;
    import java.time.LocalDate;
    import java.util.List;
    import java.util.stream.Collectors;


    @Controller
    @RequestMapping("/rents")
    public class RentsController {

        @Autowired
        private BookService bookService;
        @Autowired
        private StudentService studentService;
        @Autowired
        private RentsService rentsService;





        @GetMapping("/list")
        public String listRents(Model theModel) {
            List<Rents> theRents = rentsService.findAll();

            List<RentDTO> rentDTOList = theRents.stream()
                    .map(rents -> {
                        Book book = rents.getBook();
                        String title = (book != null) ? book.getTitle() : "Unknown Title";
                        return new RentDTO(rents, title, rents.getBookCode(), rents.getStudentId());
                    })
                    .collect(Collectors.toList());

            theModel.addAttribute("rents", rentDTOList);
            return "rents/list-rents";
        }

        @GetMapping("/showFormForAdd")
        public String showFormForAdd(Model theModel) {
            Rents theBook = new Rents();

            theModel.addAttribute("rents", theBook);
            return "rents/rents-form";
        }

        @GetMapping("/showFormForUpdate")
        public String showFormForUpdate(@RequestParam("rentsId") int theId, Model theModel) {
            Rents theRents = rentsService.findById(theId);
            theModel.addAttribute("rents", theRents);
            return "rents/rents-form";
        }


        @GetMapping("/delete")
        public String delete(@RequestParam("rentsId") int theId) {
            rentsService.deleteById(theId);
            return "redirect:/rents/list";
        }

        @PostMapping("/save")
        public String saveEmployee(@ModelAttribute("rents") Rents theRents, BindingResult bindingResult) {
            int bookCode = theRents.getBookCode();
            int studentId = theRents.getStudentId();

            Book book = bookService.findByCode(bookCode);
            Student student = studentService.findById(studentId);

            if (book == null) {
                bindingResult.rejectValue("bookCode", "error.rents", "Książka o podanym kodzie nie istnieje");
                return "rents/rents-form";
            }

            if (student == null) {
                bindingResult.rejectValue("studentId", "error.rents", "Student o podanym id nie istnieje");
                return "rents/rents-form";
            }

            theRents.setBook(book);
            theRents.setStudent(student);

            LocalDate startDate = theRents.getRentStartDate();
            LocalDate endDate = startDate.plusWeeks(2);
            theRents.setRentEndDate(endDate);

            rentsService.save(theRents);

            return "redirect:/rents/list";
        }



        @GetMapping("/books-table")
        public String showBooksTable(Model model) {

                List<Book> theBooks = bookService.findAll();
            model.addAttribute("books",theBooks);

            return "rents/books";
        }
    }
