package app.service;

import app.model.ToKhai;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ToKhaiService {
    public static List<String> genderList = new ArrayList<>();
    public static List<String> vehicleList = new ArrayList<>();
    public static Map<String, ToKhai> toKhaiMap = new HashMap<>();

    static {
        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("LGBT");

        vehicleList.add("Tàu bay");
        vehicleList.add("Tàu thuyền");
        vehicleList.add("Ô tô");
        vehicleList.add("Xe Máy");
        vehicleList.add("Khác (Ghi rõ)");

        toKhaiMap.put("00001", new ToKhai("Tan", "2812", "Nam", "Việt Nam", "00001", "Tàu bay", "81-s1", "01/05/2023", "06/05/2023", "Gia Lai", "ChuPuh", "IaLe", "096972534", "dinvnhat@gmail.com"));
        toKhaiMap.put("00002", new ToKhai("Tuan", "1111", "Nam", "Việt Nam", "00002", "Ô tô", "92-F1", "26/05/2023", "01/06/2023", "Dai Loc", "Dai Lanh", "Bình Thuận", "082251467", "huynhanh@gmail.com"));
        toKhaiMap.put("00003", new ToKhai("Khoa", "2000", "Nam", "Việt Nam", "00003", "Xe Máy", "43-B1", "01/05/2023", "06/05/2023", "Đà Nẵng", "Hoa Khanh", "Hòa Xuân", "076927108", "khoaHuynh@gmail.com"));
    }

    public List<ToKhai> findAll() {
        return new ArrayList<>(toKhaiMap.values());
    }

    public List<String> genderList() {
        return genderList;
    }

    public List<String> vehicleList() {
        return vehicleList;
    }

    public void create(ToKhai toKhai) {
        toKhaiMap.put(toKhai.getCmnd(),toKhai);
    }

    public boolean update(ToKhai toKhai) {
        if(toKhaiMap.containsKey(toKhai.getCmnd())){
            toKhaiMap.put(toKhai.getCmnd(),toKhai);
            return true;
        }
        return false;
    }

    public ToKhai findByIdentifyCard(String ICard) {
        return toKhaiMap.get(ICard);
    }
}
