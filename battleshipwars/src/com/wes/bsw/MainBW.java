package com.wes.bsw;

import java.text.Format;

public class MainBW {
    public static  void main(String[] args) {

        BattleFiled bField = new BattleFiled();
        bField.placeBS();
        bField.showField();
        while (bField.getMyShips() >0 && bField.getPcShips()>0) {
            bField.playerShoot();
            bField.PcShoot();
            bField.showField();
        }
        bField.checkWinner();
    }
}

