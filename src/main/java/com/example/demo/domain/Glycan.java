package com.example.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




// We want the image in database so we don't use javax.


@Entity // This tells Hibernate to create a table of this class
    public class Glycan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	By @GeneratedValue, JPA makes a unique key automatically and applies the key to the field having @Id
	private long id;
        private String DatabaseID; // maybe convert this to string. 
        private String Oxford;
	private float NeutralMass;
        private float ObservedMZ;
        private float CS_M_Plus_2H_Charge_2;
        private float ObservedMZ2;
        private float CCS_M_Plus_H_Plus_Na_Charge_2;
        
        
      //  @Column(nullable = true, length = 64)
      //  private String GlycanPhoto;
        // was already associated with column 'glycan_photo' when I created it in table, so i can't change that name.
        // alongside this i created 'glycan_photo' before 'GlycanPhoto' and therefore deleting 'glycan_photo'
        //causes a 'could not execute statement'. In the future observe in sql where the values are input, and then choose correct column


    
    // change above to byte - Aug 22 this might be the method. then redirect -> return
        // if not try github code . (so byte above for both of them)
        

	public Glycan() {

    }
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
       

    /**
     * @return the DatabaseID
     */
    public String getDatabaseID() {
        return DatabaseID;
    }

    /**
     * @param DatabaseID the DatabaseID to set
     */
    public void setDatabaseID(String DatabaseID) {
        this.DatabaseID = DatabaseID;
        
    }

    
        /**
     * @return the Oxford
     */
    public String getOxford() {
        return Oxford;
    }

    /**
     * @param Oxford the Oxford to set
     */
    public void setOxford(String Oxford) {
        this.Oxford = Oxford;
    }
    
    /**
     * @return the NeutralMass
     */
    public float getNeutralMass() {
        return NeutralMass;
    }

    /**
     * @param NeutralMass the NeutralMass to set
     */
    public void setNeutralMass(float NeutralMass) {
        this.NeutralMass = NeutralMass;
    }

    /**
     * @return the ObservedMZ
     */
    public float getObservedMZ() {
        return ObservedMZ;
    }

    /**
     * @param ObservedMZ the ObservedMZ to set
     */
    public void setObservedMZ(float ObservedMZ) {
        this.ObservedMZ = ObservedMZ;
    }

    /**
     * @return the CS_M_Plus_2H_Charge
     */
    public float getCS_M_Plus_2H_Charge_2() {
        return CS_M_Plus_2H_Charge_2;
    }

    /**
     * @param CS_M_Plus_2H_Charge the CS_M_Plus_2H_Charge to set
     */
    public void setCS_M_Plus_2H_Charge_2(float CS_M_Plus_2H_Charge_2) {
        this.CS_M_Plus_2H_Charge_2 = CS_M_Plus_2H_Charge_2;
    }

    /**
     * @return the ObservedMZ2
     */
    public float getObservedMZ2() {
        return ObservedMZ2;
    }

    /**
     * @param ObservedMZ2 the ObservedMZ2 to set
     */
    public void setObservedMZ2(float ObservedMZ2) {
        this.ObservedMZ2 = ObservedMZ2;
    }

    /**
     * @return the CCS_M_Plus_H_Plus_Na_Charge_2
     */
    public float getCCS_M_Plus_H_Plus_Na_Charge_2() {
        return CCS_M_Plus_H_Plus_Na_Charge_2;
    }

    /**
     * @param CCS_M_Plus_H_Plus_Na_Charge_2 the CCS_M_Plus_H_Plus_Na_Charge_2 to set
     */
    public void setCCS_M_Plus_H_Plus_Na_Charge_2(
            float CCS_M_Plus_H_Plus_Na_Charge_2) {
        this.CCS_M_Plus_H_Plus_Na_Charge_2 = CCS_M_Plus_H_Plus_Na_Charge_2;
    }

    /**
     * @return the PhotosImagePath
     */
    

    
    //although not called in thymeleaf, it's part of my method to link to controller as a getter.
    //in contrast to the tutorial https://www.codejava.net/frameworks/spring-boot/spring-boot-file-upload-tutorial, 
    //i do glycan.GlycanPhoto in thymeleaf, as this is the photo string. he made a mistake.
    // my controller still runs to put the string in the column.
    // the 'getphotosimagepath' is interpreted as a string literal and not the GlycanPhoto string.
// needed or 'Uncompilable code - cannot find symbol symbol: method getPhotosImagePath() location: variable gly of type com.example.demo.domain.Glycan'
    /**
     * @param PhotosImagePath the PhotosImagePath to set
     */

	//@Override
	//public String toString() {
	//	return "Product [id=" + id + ", Oxford=" + Oxford + ", DatabaseID=" + DatabaseID + ", NeutralMass=" + NeutralMass + ", ObservedMZ="
	//			+ ObservedMZ + ", CS_M_Plus_2H_Charge_2="
	//			+ CS_M_Plus_2H_Charge_2 + ", ObservedMZ2="
	//			+ ObservedMZ2 + ", CCS_M_Plus_H_Plus_Na_Charge_2="
	//			+ CCS_M_Plus_H_Plus_Na_Charge_2 + ", PhotosImagePath="
	//			+ Arrays.toString(PhotosImagePath) + "]";
	//}



}
