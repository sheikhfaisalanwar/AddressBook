package AddressBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import AddressBook.BuddyRepository.*;
import AddressBook.AddressBookRepository;

import javax.annotation.PostConstruct;


@Controller
public class AddressBookController {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @Autowired
    private BuddyRepository repository;
    private AddressBook book;


    @RequestMapping("/newBook")
    public String create( Model model) {
        return "newBook";
    }

    @RequestMapping(value = "/newBuddy", method = RequestMethod.GET)
    public String newBuddy(Model model){
        BuddyInfo buddy = new BuddyInfo();
        model.addAttribute("buddy", buddy);
        //model.addAttribute("book", book);
        return "newBuddy";
    }

   @RequestMapping(value = "/", method=RequestMethod.GET)
    public String Home(ModelMap model){
        return "index";
   }

   @RequestMapping(value = "/newBuddy", method=RequestMethod.POST)
    public String createBuddy(@ModelAttribute("buddy") BuddyInfo buddy, Model model){
        book =  addressBookRepository.findOne(1L);
        book.addBuddy(buddy);
        buddy.setAddressBook(book);
        repository.save(buddy);
        addressBookRepository.save(book);
        return "result";
    }



}
