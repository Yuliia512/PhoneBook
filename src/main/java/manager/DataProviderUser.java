package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> dataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"423090@gmail.com","Yy12345$"});
        list.add(new Object[]{"fibi@ukr.net","Ff12345$"});
        list.add(new Object[]{"sir@mail.ru","Ss12345$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> XXX(){
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataModelUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("423090@gmail.com").setPassword("Yy12345$")});
        list.add(new Object[]{new User().setEmail("fibi@ukr.net").setPassword("Ff12345$")});
        list.add(new Object[]{new User().setEmail("sir@mail.ru").setPassword("Ss12345$")});
        return list.iterator();
    }


}
