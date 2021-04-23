package lab3.ejb;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class MessageKeeper extends AMessages {
    
    @Override
    public String getMessage(String user, int index) throws InvalidParameterException {
        System.out.println("вызван метод getMessage ");
        if(messages.containsKey(user)){
            List<String> usersMessages = messages.get(user);
            if(usersMessages != null){
                if(index >= usersMessages.size() || index < 0){
                    //throw new InvalidParameterException("class MessageKeeper, метод getMessage(): нет сообщения с таким индексом!");
                    return "<p1> No message with such index.</p1>";
                }else{
                    return usersMessages.get(index);
                }
            }else{
                System.out.println("class MessageKeeper, метод getMessage(): список usersMessages == null");
                //throw new InvalidParameterException("class MessageKeeper, метод getMessage(): список usersMessages == null");  
                return "<p1> User's messages list has no messages.</p1>";
            }
        }else{
            System.out.println("class MessageKeeper, метод getMessage(): нет пользователя с таким именем.");
            //throw new InvalidParameterException("class MessageKeeper, метод getMessage(): нет пользователя с таким именем.");  
            return "<p1> No user with such name found.</p1>";
        }
    }

    @Override
    public boolean addMessage(String user, String message) {
        System.out.println("вызван метод addMessage ");
        List<String> usersMessages;
        if(messages.containsKey(user)){
            usersMessages = messages.get(user);
        }else{
            usersMessages = new ArrayList<>();
        }
        usersMessages.add(message);
        messages.put(user, usersMessages);
        return true;
    }

    @Override
    public List<String> getMessageList(String user) {
        System.out.println("вызван метод getMessageList ");
        return messages.get(user);
    }
}
