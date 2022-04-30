/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.controller;

import lk.hotelme.bo.BOFactory;
import lk.hotelme.dto.PackageDTO;
import java.util.ArrayList;
import lk.hotelme.bo.custom.PackagesBO;

/**
 *
 * @author Nadun N. T. Fernando
 */
public class PackageMethodController {
    public static PackagesBO packbo=(PackagesBO) BOFactory.getInstance().getBO(BOFactory.bOTYPES.PACKAGE);
    
    public static boolean addPackage(PackageDTO pack) throws Exception{
        return packbo.addPackage(pack);
    }
    
    public static boolean updatePackage(PackageDTO pack) throws Exception{
        return packbo.updatePackage(pack);
    }
    
    public static boolean deletePackage(String ID) throws Exception{
        return packbo.deletePackage(ID);
    }
    public static PackageDTO searchPackage(String ID) throws Exception{
        return packbo.searchPackage(ID);
    }
    
    public static ArrayList<PackageDTO> loadPackages() throws Exception{
     return packbo.loadallPackage();
    }
}
