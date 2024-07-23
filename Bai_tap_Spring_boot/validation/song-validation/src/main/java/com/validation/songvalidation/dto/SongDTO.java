package com.validation.songvalidation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SongDTO {

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Tên bài hát không được vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-…]*$", message = "Tên bài hát không được chứa các ký tự đặc biệt như @ ; , . = - + , …")
    private String nameSong;

    @NotBlank(message = "Tên nghệ sĩ không được để trống")
    @Size(max = 300, message = "Tên nghệ sĩ không được vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,.=+\\-…]*$", message = "Tên nghệ sĩ không được chứa các ký tự đặc biệt như @ ; , . = - + , …")
    private String singer;

    @NotBlank(message = "Thể loại nhạc không được để trống")
    @Size(max = 1000, message = "Thể loại nhạc không được vượt quá 1000 ký tự")
    @Pattern(regexp = "^[^@;.=+\\-…]*$", message = "Thể loại nhạc không được chứa các ký tự đặc biệt như @ ; . = + - …")
    private String category;

    public SongDTO() {
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
