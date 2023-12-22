package com.isep.projectjavawallet;

import com.isep.projectjavawallet.bean.setting.Profil;

public class test {
    public static void main(String[] args) {
        Profil profil = new Profil() ;
        System.out.println(profil.getAbout().getAboutTeam());
    }
}
