package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;    
import javax.persistence.GenerationType;
import javax.persistence.Id;




// We want the image in database so we don't use javax.


@Entity // This tells Hibernate to create a table of this class.
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    public class Glycan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//	By @GeneratedValue, JPA makes a unique key automatically and applies the key to the field having @Id
	private long id;
        private String databaseID; // maybe convert this to string. 
        private String oxford;
	private String neutralmass;
        private String observedmz;
        private String ccs1;
        private String observedmz2;
        private String ccs2;
        
        
      //  @Column(nullable = true, length = 64)
      //  private String GlycanPhoto;
        // was already associated with column 'glycan_photo' when I created it in table, so i can't change that name.
        // alongside this i created 'glycan_photo' before 'GlycanPhoto' and therefore deleting 'glycan_photo'
        //causes a 'could not execute statement'. In the future observe in sql where the values are input, and then choose correct column


    
    // change above to byte - Aug 22 this might be the method. then redirect -> return
        // if not try github code . (so byte above for both of them)
        

	public Glycan() {

    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the databaseID
     */
    public String getDatabaseID() {
        return databaseID;
    }

    /**
     * @param databaseID the databaseID to set
     */
    public void setDatabaseID(String databaseID) {
        this.databaseID = databaseID;
    }

    /**
     * @return the oxford
     */
    public String getOxford() {
        return oxford;
    }

    /**
     * @param oxford the oxford to set
     */
    public void setOxford(String oxford) {
        this.oxford = oxford;
    }

    /**
     * @return the neutralmass
     */
    public String getNeutralmass() {
        return neutralmass;
    }

    /**
     * @param neutralmass the neutralmass to set
     */
    public void setNeutralmass(String neutralmass) {
        this.neutralmass = neutralmass;
    }

    /**
     * @return the observedmz
     */
    public String getObservedmz() {
        return observedmz;
    }

    /**
     * @param observedmz the observedmz to set
     */
    public void setObservedmz(String observedmz) {
        this.observedmz = observedmz;
    }

    /**
     * @return the ccs1
     */
    public String getCcs1() {
        return ccs1;
    }

    /**
     * @param ccs1 the ccs1 to set
     */
    public void setCcs1(String ccs1) {
        this.ccs1 = ccs1;
    }

    /**
     * @return the observedmz2
     */
    public String getObservedmz2() {
        return observedmz2;
    }

    /**
     * @param observedmz2 the observedmz2 to set
     */
    public void setObservedmz2(String observedmz2) {
        this.observedmz2 = observedmz2;
    }

    /**
     * @return the ccs2
     */
    public String getCcs2() {
        return ccs2;
    }

    /**
     * @param ccs2 the ccs2 to set
     */
    public void setCcs2(String ccs2) {
        this.ccs2 = ccs2;
    }
	



    
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
	//	return "Product [id=" + id + ", oxford=" + oxford + ", databaseID=" + databaseID + ", neutralmass=" + neutralmass + ", observedmz="
	//			+ observedmz + ", ccs1="
	//			+ ccs1 + ", observedmz2="
	//			+ observedmz2 + ", ccs2="
	//			+ ccs2 + ", PhotosImagePath="
	//			+ Arrays.toString(PhotosImagePath) + "]";
	//}
	 // @Override
	  //public String toString() {
	    //return "Table [id=" + id + ", databaseID=" + databaseID + ", oxford=" + oxford + ", neutralmass=" + neutralmass + ", "
              //      + "observedmz=" + observedmz + ", ccs1=" + ccs1 + ", "
                //    + "observedmz2=" + observedmz2 + ", ccs2=" + ccs2 + "]";  
                    
	 // }

	//public Glycan(Long id, String databaseID, String oxford, Float neutralmass, Float observedmz, Float ccs1,
          //      Float observedmz2, Float ccs2) {
	//	super();
	//	this.id = id;
	//	this.databaseID = databaseID;
	//	this.oxford = oxford;
	//	this.neutralmass = neutralmass;
	//	this.observedmz = observedmz;
          //      this.ccs1 = ccs1;
            //    this.observedmz2 = observedmz2;
              //  this.ccs2 = ccs2;
     
//	}
}
