package selenium.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataPool {
    Collection<User> users;

    public void processDataFile(String filePath) {
        users = new ArrayList<User>();
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        objectMapper.setDateFormat(date);

        try{
            User user = objectMapper.readValue(new File(filePath),User.class);
            users.add(user);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public Object[][] getData(String criteria) {
        Object[][] data = new Object[users.size()][1];
        Iterator<User> it = users.iterator();
        int i = 0;
        while (it.hasNext()) {
            data[i][0] = it.next();
            i++;
        }
        return data;
    }
}
