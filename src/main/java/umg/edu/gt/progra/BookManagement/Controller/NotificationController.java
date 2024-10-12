/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.edu.gt.progra.BookManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import umg.edu.gt.progra.BookManagement.Service.NotificationService;

/**
 *
 * @author J MAX
 */
@RestController 
public class NotificationController {
    
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/sendNotification")
    public String sendNotification() {
        notificationService.sendNotification("Hello, this is a notification message!");
        return "Message sent";
    }    
}
