/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.hotelme.bo.custom;

import lk.hotelme.bo.SuperBO;
import lk.hotelme.dto.PackageDTO;
import java.util.ArrayList;

/**
 *
 * @author Nadun N. T. Fernando
 */
public interface PackagesBO extends SuperBO {

    public boolean addPackage(PackageDTO pack) throws Exception;

    public boolean updatePackage(PackageDTO pack) throws Exception;

    public boolean deletePackage(String ID) throws Exception;

    public PackageDTO searchPackage(String ID) throws Exception;

    public ArrayList<PackageDTO> loadallPackage() throws Exception;

}
