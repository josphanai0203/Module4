package app.service;

import app.modal.SettingMail;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class SettingMailService {
    public SettingMailService() {
    }

    public SettingMail main = new SettingMail();
    public void updateSM(SettingMail settingMail){
        main = settingMail;
    }
    public ArrayList<String> getLanguages(){
        ArrayList<String> list = new ArrayList<>();
        list.add("English");
        list.add("Vietnamese");
        list.add("Japanese");
        list.add("Chinese");
        return list;
    }
    public ArrayList<Integer> getSize(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(25);
        list.add(50);
        list.add(100);
        return list;
    }
}
