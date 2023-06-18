/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basharat.vehicles.Models;

import java.util.Objects;

/**
 *
 * @author rehma
 */
public class Brand {
    private final int brandId;
    private String brandName;
    
    public Brand(String brandName){
        this(0, brandName);
    }
    
    public Brand(int brandId, Brand original){
        this(brandId, original.brandName);
    }

    public Brand(int brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = Objects.requireNonNull(brandName);
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }
    
}
