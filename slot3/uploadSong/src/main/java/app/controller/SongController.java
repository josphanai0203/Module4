package app.controller;

import app.model.Song;
import app.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private SongService songService;
    @GetMapping("")
    public String getDefault(Model model){
        model.addAttribute("list",songService.findAll());
        return "song/list";
    }
    @PostMapping ("/save")
    public String saveProduct(@ModelAttribute("song") Song song) {
        MultipartFile multipartFile = song.getLink();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(song.getLink().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        song.setSrcLink(fileUpload + fileName);
        songService.save(song);

        return "redirect:/list";
    }
    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("list",songService.findAll());
        return "song/list";
    }
    @GetMapping("/upload")
    public String getFileUpload(Model model){
        model.addAttribute("song",new Song());
        return "song/upload";
    }

}
