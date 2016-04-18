package org.acteacademie.modelfinder.domain;

	import java.sql.Date;
	import java.sql.Time;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.EnumType;
	import javax.persistence.Enumerated;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.Table;

	import org.acteacademie.modelfinder.enums.CategoriesEnum;
	import org.acteacademie.modelfinder.enums.EyeColorEnum;
	import org.acteacademie.modelfinder.enums.LengthHairEnum;
	import org.acteacademie.modelfinder.enums.SkinToneEnum;
	import org.hibernate.annotations.NotFound;
	import org.hibernate.annotations.NotFoundAction;

		@Entity
		@Table(name="MODELE")
		public class Model{
			
			@Id
			@Column(name="ID_MODELE")
			@GeneratedValue(strategy=GenerationType.AUTO)
			private long id;
			
			@Column(name="PASSWORD_MODELE", unique = false, nullable = false)
			private String password;
			
			@Column(name="NOM", unique= true, nullable = true)
			private String lastName;
			
			@Column(name="PRENOM", unique = false, nullable = false)
			private String name;

			@Column(name="MAIL", unique = false, nullable = false)
			private String mail;
			
			@Column(name="DATE_NAISSANCE", unique = false, nullable = false)
			private Date dateOfBirth;
			
			@Column(name="SEXE", unique = false, nullable = false)
			private String gender;
			
			//@Column(name="NUM_TELEPHONE", unique = false, nullable = false)
			//private String phoneNumber;
			
			@Column(name="CARNATION_PEAU", unique = false, nullable = false)
			@Enumerated(EnumType.STRING)
			private SkinToneEnum skinTone;

			@Column(name="COULEUR_CHEVEUX", unique = false, nullable = false)
			private String hairColor;
			
			@Column(name="COULEUR_YEUX", unique = false, nullable = false)
			@Enumerated(EnumType.STRING)
			private EyeColorEnum eyeColor;
			
			@Column(name="LONGUEUR_CHEVEUX", unique = false, nullable = false)
			@Enumerated(EnumType.STRING)
			private LengthHairEnum lengthHair;
			
			@Column(name="TAILLE", unique = false, nullable = false)
			private long height;
			
			@Column(name="POINTURE", unique = false, nullable = false)
			private long shoeSize;
			
			@Column(name="TAILLE_HAUT", unique = false, nullable = false)
			private long highHeight;

			@Column(name="TAILLE_BAS", unique = false, nullable = false)
			private long lowHeight;

			@Column(name="DESCRIPTION", unique = false, nullable = false)
			private String description;
			
			@Column(name="COMMENTAIRE", unique = false, nullable = false)
			private String comment;

			@Column(name="EST_VALIDE", unique = false, nullable = false)
			private String isValidated;

			protected Model(){}

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getMail() {
				return mail;
			}

			public void setMail(String mail) {
				this.mail = mail;
			}

			public Date getDateOfBirth() {
				return dateOfBirth;
			}

			public void setDateOfBirth(Date dateOfBirth) {
				this.dateOfBirth = dateOfBirth;
			}

			public String getGender() {
				return gender;
			}

			public void setGender(String gender) {
				this.gender = gender;
			}

			public String getPhoneNumber() {
				return "";
				//return phoneNumber;
			}

			public void setPhoneNumber(String phoneNumber) {
				//this.phoneNumber = phoneNumber;
			}

			public SkinToneEnum getSkinTone() {
				return skinTone;
			}

			public void setSkinTone(SkinToneEnum skinTone) {
				this.skinTone = skinTone;
			}

			public String getHairColor() {
				return hairColor;
			}

			public void setHairColor(String hairColor) {
				this.hairColor = hairColor;
			}

			public EyeColorEnum getEyeColor() {
				return eyeColor;
			}

			public void setEyeColor(EyeColorEnum eyeColor) {
				this.eyeColor = eyeColor;
			}

			public LengthHairEnum getLengthHair() {
				return lengthHair;
			}

			public void setLengthHair(LengthHairEnum lengthHair) {
				this.lengthHair = lengthHair;
			}

			public long getHeight() {
				return height;
			}

			public void setHeight(long height) {
				this.height = height;
			}

			public long getShoeSize() {
				return shoeSize;
			}

			public void setShoeSize(long shoeSize) {
				this.shoeSize = shoeSize;
			}

			public long getHighHeight() {
				return highHeight;
			}

			public void setHighHeight(long highHeight) {
				this.highHeight = highHeight;
			}

			public long getLowHeight() {
				return lowHeight;
			}

			public void setLowHeight(long lowHeight) {
				this.lowHeight = lowHeight;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public String getComment() {
				return comment;
			}

			public void setComment(String comment) {
				this.comment = comment;
			}

			public String getIsValidated() {
				return isValidated;
			}

			public void setIsValidated(String isValidated) {
				this.isValidated = isValidated;
			}
			
			@Override
			public String toString() {
				return "Model [id=" + id + ", nom=" + lastName + ", prenom=" + name + "]";
			}
}