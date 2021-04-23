/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.web;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import lab3.ejb.MessageKeeper;

/**
 *
 * @author zi
 */
@WebService(serviceName = "IDemo")
public class IDemoImpl implements IDemo {

    @EJB
    private MessageKeeper messageKeeper;

    @Override
    public boolean add(String user, String message) {
        System.out.println("вызван метод add веб-службы");
        return messageKeeper.addMessage(user, message);
    }

    @Override
    public String getMessage(String user, int index) {
        System.out.println("вызван метод getMessage веб-службы");
        return messageKeeper.getMessage(user, index);
    }

    @Override
    public List<String> getAllMessage(String user) {
        System.out.println("вызван метод getAllMessage веб-службы");
        return messageKeeper.getMessageList(user);
    }
}
