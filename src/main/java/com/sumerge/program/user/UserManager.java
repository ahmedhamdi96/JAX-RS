package com.sumerge.program.user;

import java.util.ArrayList;

public class UserManager {

    public static ArrayList<User> users = new ArrayList<User>() {
        {
            add(new User(1, "ahmed", "ahmed@live.com"));
            add(new User(2, "omar", "omar@live.com"));
            add(new User(3, "amr", "amr@live.com"));
        }
    };

    public String getUsers(){
        String all_users = "";

        for (User u:users){
            all_users+=u.toString()+", ";
        }

        return all_users;
    }

    public String getUser(int id){
        User user = null;

        for (User u:users){
            if (u.getId() == id){
                user = u;
                break;
            }
        }

        return user.toString();
    }

    public void deleteUser(int id){
        for (User u:users){
            if (u.getId() == id){
                users.remove(u);
                break;
            }
        }
    }

    public void updateUser(User user){
        for (int i=0; i< users.size(); i++){
            if (users.get(i).getId() == user.getId()){
                users.get(i).setName(user.getName());
                users.get(i).setName(user.getName());
                break;
            }
        }
    }

}
