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

    public User createUser(User user){
        users.add(user);
        return users.get(users.size()-1);
    }

    public ArrayList<User> readUsers(){
        return users;
    }

    public User readUser(int id){
        User user = null;

        for (User u:users){
            if (u.getId() == id){
                user = u;
                break;
            }
        }

        return user;
    }

    public User updateUser(User user){
        int index = 0;

        for (int i=0; i< users.size(); i++){
            if (users.get(i).getId() == user.getId()){
                users.get(i).setName(user.getName());
                users.get(i).setEmail(user.getEmail());
                index = i;
                break;
            }
        }

        return users.get(index);
    }

    public String deleteUser(int id){
        for (User u:users){
            if (u.getId() == id){
                users.remove(u);
                break;
            }
        }
        return "User Deleted Successfully.";
    }

}
