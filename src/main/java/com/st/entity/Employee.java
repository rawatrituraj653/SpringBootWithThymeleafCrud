package com.st.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="EMP_THYM")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
	
	@Id
	@Column(name="EMP_ID")
	@GeneratedValue
	@NonNull
	private Integer empId;
	@Column(name="EMP_NAME")
	@NonNull
	private String empName;
	@Column(name="EMP_SAL")
	@NonNull
	private Double empSal;
	@Column(name="EMP_DEPT")
	@NonNull
	private Integer empDept;
	
	@Column(name="EMP_ADDR")
	@NonNull
	private String empAddr;
}
