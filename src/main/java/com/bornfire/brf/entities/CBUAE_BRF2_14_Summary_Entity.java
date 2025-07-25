package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CBUAE_BRF2_14_SUMMARYTABLE")

public class CBUAE_BRF2_14_Summary_Entity {
	
	private String	r0010_loantype;
	private String	r0020_loantype;
	private String	r0030_loantype;
	private BigDecimal	r0030_new_loan_in_month_resi;
	private BigDecimal	r0030_min_interest_rate_resi;
	private BigDecimal	r0030_max_interest_rate_resi;
	private BigDecimal	r0030_weighted_interest_resi;
	private BigDecimal	r0030_total_loan_outstanding_resi;
	private BigDecimal	r0030_total_interest_income_resi;
	private BigDecimal	r0030_new_loan_in_month_nonresi;
	private BigDecimal	r0030_min_interest_rate_nonresi;
	private BigDecimal	r0030_max_interest_rate_nonresi;
	private BigDecimal	r0030_weighted_interest_nonresi;
	private BigDecimal	r0030_total_loan_outstanding_nonresi;
	private BigDecimal	r0030_total_interest_income_nonresi;
	private String	r0040_loantype;
	private BigDecimal	r0040_new_loan_in_month_resi;
	private BigDecimal	r0040_min_interest_rate_resi;
	private BigDecimal	r0040_max_interest_rate_resi;
	private BigDecimal	r0040_weighted_interest_resi;
	private BigDecimal	r0040_total_loan_outstanding_resi;
	private BigDecimal	r0040_total_interest_income_resi;
	private BigDecimal	r0040_new_loan_in_month_nonresi;
	private BigDecimal	r0040_min_interest_rate_nonresi;
	private BigDecimal	r0040_max_interest_rate_nonresi;
	private BigDecimal	r0040_weighted_interest_nonresi;
	private BigDecimal	r0040_total_loan_outstanding_nonresi;
	private BigDecimal	r0040_total_interest_income_nonresi;
	private String	r0050_loantype;
	private BigDecimal	r0050_new_loan_in_month_resi;
	private BigDecimal	r0050_min_interest_rate_resi;
	private BigDecimal	r0050_max_interest_rate_resi;
	private BigDecimal	r0050_weighted_interest_resi;
	private BigDecimal	r0050_total_loan_outstanding_resi;
	private BigDecimal	r0050_total_interest_income_resi;
	private BigDecimal	r0050_new_loan_in_month_nonresi;
	private BigDecimal	r0050_min_interest_rate_nonresi;
	private BigDecimal	r0050_max_interest_rate_nonresi;
	private BigDecimal	r0050_weighted_interest_nonresi;
	private BigDecimal	r0050_total_loan_outstanding_nonresi;
	private BigDecimal	r0050_total_interest_income_nonresi;
	private String	r0060_loantype;
	private String	r0070_loantype;
	private BigDecimal	r0070_new_loan_in_month_resi;
	private BigDecimal	r0070_min_interest_rate_resi;
	private BigDecimal	r0070_max_interest_rate_resi;
	private BigDecimal	r0070_weighted_interest_resi;
	private BigDecimal	r0070_total_loan_outstanding_resi;
	private BigDecimal	r0070_total_interest_income_resi;
	private BigDecimal	r0070_new_loan_in_month_nonresi;
	private BigDecimal	r0070_min_interest_rate_nonresi;
	private BigDecimal	r0070_max_interest_rate_nonresi;
	private BigDecimal	r0070_weighted_interest_nonresi;
	private BigDecimal	r0070_total_loan_outstanding_nonresi;
	private BigDecimal	r0070_total_interest_income_nonresi;
	private String	r0080_loantype;
	private BigDecimal	r0080_new_loan_in_month_resi;
	private BigDecimal	r0080_min_interest_rate_resi;
	private BigDecimal	r0080_max_interest_rate_resi;
	private BigDecimal	r0080_weighted_interest_resi;
	private BigDecimal	r0080_total_loan_outstanding_resi;
	private BigDecimal	r0080_total_interest_income_resi;
	private BigDecimal	r0080_new_loan_in_month_nonresi;
	private BigDecimal	r0080_min_interest_rate_nonresi;
	private BigDecimal	r0080_max_interest_rate_nonresi;
	private BigDecimal	r0080_weighted_interest_nonresi;
	private BigDecimal	r0080_total_loan_outstanding_nonresi;
	private BigDecimal	r0080_total_interest_income_nonresi;
	private String	r0090_loantype;
	private BigDecimal	r0090_new_loan_in_month_resi;
	private BigDecimal	r0090_min_interest_rate_resi;
	private BigDecimal	r0090_max_interest_rate_resi;
	private BigDecimal	r0090_weighted_interest_resi;
	private BigDecimal	r0090_total_loan_outstanding_resi;
	private BigDecimal	r0090_total_interest_income_resi;
	private BigDecimal	r0090_new_loan_in_month_nonresi;
	private BigDecimal	r0090_min_interest_rate_nonresi;
	private BigDecimal	r0090_max_interest_rate_nonresi;
	private BigDecimal	r0090_weighted_interest_nonresi;
	private BigDecimal	r0090_total_loan_outstanding_nonresi;
	private BigDecimal	r0090_total_interest_income_nonresi;
	private String	r0100_loantype;
	private BigDecimal	r0100_new_loan_in_month_resi;
	private BigDecimal	r0100_min_interest_rate_resi;
	private BigDecimal	r0100_max_interest_rate_resi;
	private BigDecimal	r0100_weighted_interest_resi;
	private BigDecimal	r0100_total_loan_outstanding_resi;
	private BigDecimal	r0100_total_interest_income_resi;
	private BigDecimal	r0100_new_loan_in_month_nonresi;
	private BigDecimal	r0100_min_interest_rate_nonresi;
	private BigDecimal	r0100_max_interest_rate_nonresi;
	private BigDecimal	r0100_weighted_interest_nonresi;
	private BigDecimal	r0100_total_loan_outstanding_nonresi;
	private BigDecimal	r0100_total_interest_income_nonresi;
	private String	r0110_loantype;
	private BigDecimal	r0110_new_loan_in_month_resi;
	private BigDecimal	r0110_min_interest_rate_resi;
	private BigDecimal	r0110_max_interest_rate_resi;
	private BigDecimal	r0110_weighted_interest_resi;
	private BigDecimal	r0110_total_loan_outstanding_resi;
	private BigDecimal	r0110_total_interest_income_resi;
	private BigDecimal	r0110_new_loan_in_month_nonresi;
	private BigDecimal	r0110_min_interest_rate_nonresi;
	private BigDecimal	r0110_max_interest_rate_nonresi;
	private BigDecimal	r0110_weighted_interest_nonresi;
	private BigDecimal	r0110_total_loan_outstanding_nonresi;
	private BigDecimal	r0110_total_interest_income_nonresi;
	private String	r0120_loantype;
	private BigDecimal	r0120_new_loan_in_month_resi;
	private BigDecimal	r0120_min_interest_rate_resi;
	private BigDecimal	r0120_max_interest_rate_resi;
	private BigDecimal	r0120_weighted_interest_resi;
	private BigDecimal	r0120_total_loan_outstanding_resi;
	private BigDecimal	r0120_total_interest_income_resi;
	private BigDecimal	r0120_new_loan_in_month_nonresi;
	private BigDecimal	r0120_min_interest_rate_nonresi;
	private BigDecimal	r0120_max_interest_rate_nonresi;
	private BigDecimal	r0120_weighted_interest_nonresi;
	private BigDecimal	r0120_total_loan_outstanding_nonresi;
	private BigDecimal	r0120_total_interest_income_nonresi;
	private String	r0130_loantype;
	private BigDecimal	r0130_new_loan_in_month_resi;
	private BigDecimal	r0130_min_interest_rate_resi;
	private BigDecimal	r0130_max_interest_rate_resi;
	private BigDecimal	r0130_weighted_interest_resi;
	private BigDecimal	r0130_total_loan_outstanding_resi;
	private BigDecimal	r0130_total_interest_income_resi;
	private BigDecimal	r0130_new_loan_in_month_nonresi;
	private BigDecimal	r0130_min_interest_rate_nonresi;
	private BigDecimal	r0130_max_interest_rate_nonresi;
	private BigDecimal	r0130_weighted_interest_nonresi;
	private BigDecimal	r0130_total_loan_outstanding_nonresi;
	private BigDecimal	r0130_total_interest_income_nonresi;
	private String	r0140_loantype;
	private String	r0150_loantype;
	private BigDecimal	r0150_new_loan_in_month_resi;
	private BigDecimal	r0150_min_interest_rate_resi;
	private BigDecimal	r0150_max_interest_rate_resi;
	private BigDecimal	r0150_weighted_interest_resi;
	private BigDecimal	r0150_total_loan_outstanding_resi;
	private BigDecimal	r0150_total_interest_income_resi;
	private BigDecimal	r0150_new_loan_in_month_nonresi;
	private BigDecimal	r0150_min_interest_rate_nonresi;
	private BigDecimal	r0150_max_interest_rate_nonresi;
	private BigDecimal	r0150_weighted_interest_nonresi;
	private BigDecimal	r0150_total_loan_outstanding_nonresi;
	private BigDecimal	r0150_total_interest_income_nonresi;
	private String	r0160_loantype;
	private BigDecimal	r0160_new_loan_in_month_resi;
	private BigDecimal	r0160_min_interest_rate_resi;
	private BigDecimal	r0160_max_interest_rate_resi;
	private BigDecimal	r0160_weighted_interest_resi;
	private BigDecimal	r0160_total_loan_outstanding_resi;
	private BigDecimal	r0160_total_interest_income_resi;
	private BigDecimal	r0160_new_loan_in_month_nonresi;
	private BigDecimal	r0160_min_interest_rate_nonresi;
	private BigDecimal	r0160_max_interest_rate_nonresi;
	private BigDecimal	r0160_weighted_interest_nonresi;
	private BigDecimal	r0160_total_loan_outstanding_nonresi;
	private BigDecimal	r0160_total_interest_income_nonresi;
	private String	r0170_loantype;
	private BigDecimal	r0170_new_loan_in_month_resi;
	private BigDecimal	r0170_min_interest_rate_resi;
	private BigDecimal	r0170_max_interest_rate_resi;
	private BigDecimal	r0170_weighted_interest_resi;
	private BigDecimal	r0170_total_loan_outstanding_resi;
	private BigDecimal	r0170_total_interest_income_resi;
	private BigDecimal	r0170_new_loan_in_month_nonresi;
	private BigDecimal	r0170_min_interest_rate_nonresi;
	private BigDecimal	r0170_max_interest_rate_nonresi;
	private BigDecimal	r0170_weighted_interest_nonresi;
	private BigDecimal	r0170_total_loan_outstanding_nonresi;
	private BigDecimal	r0170_total_interest_income_nonresi;
	private String	r0180_loantype;
	private String	r0190_loantype;
	private BigDecimal	r0190_new_loan_in_month_resi;
	private BigDecimal	r0190_min_interest_rate_resi;
	private BigDecimal	r0190_max_interest_rate_resi;
	private BigDecimal	r0190_weighted_interest_resi;
	private BigDecimal	r0190_total_loan_outstanding_resi;
	private BigDecimal	r0190_total_interest_income_resi;
	private BigDecimal	r0190_new_loan_in_month_nonresi;
	private BigDecimal	r0190_min_interest_rate_nonresi;
	private BigDecimal	r0190_max_interest_rate_nonresi;
	private BigDecimal	r0190_weighted_interest_nonresi;
	private BigDecimal	r0190_total_loan_outstanding_nonresi;
	private BigDecimal	r0190_total_interest_income_nonresi;
	private String	r0200_loantype;
	private BigDecimal	r0200_new_loan_in_month_resi;
	private BigDecimal	r0200_min_interest_rate_resi;
	private BigDecimal	r0200_max_interest_rate_resi;
	private BigDecimal	r0200_weighted_interest_resi;
	private BigDecimal	r0200_total_loan_outstanding_resi;
	private BigDecimal	r0200_total_interest_income_resi;
	private BigDecimal	r0200_new_loan_in_month_nonresi;
	private BigDecimal	r0200_min_interest_rate_nonresi;
	private BigDecimal	r0200_max_interest_rate_nonresi;
	private BigDecimal	r0200_weighted_interest_nonresi;
	private BigDecimal	r0200_total_loan_outstanding_nonresi;
	private BigDecimal	r0200_total_interest_income_nonresi;
	private String	r0210_loantype;
	private BigDecimal	r0210_new_loan_in_month_resi;
	private BigDecimal	r0210_min_interest_rate_resi;
	private BigDecimal	r0210_max_interest_rate_resi;
	private BigDecimal	r0210_weighted_interest_resi;
	private BigDecimal	r0210_total_loan_outstanding_resi;
	private BigDecimal	r0210_total_interest_income_resi;
	private BigDecimal	r0210_new_loan_in_month_nonresi;
	private BigDecimal	r0210_min_interest_rate_nonresi;
	private BigDecimal	r0210_max_interest_rate_nonresi;
	private BigDecimal	r0210_weighted_interest_nonresi;
	private BigDecimal	r0210_total_loan_outstanding_nonresi;
	private BigDecimal	r0210_total_interest_income_nonresi;
	private String	r0220_loantype;
	private String	r0230_loantype;
	private BigDecimal	r0230_new_loan_in_month_resi;
	private BigDecimal	r0230_min_interest_rate_resi;
	private BigDecimal	r0230_max_interest_rate_resi;
	private BigDecimal	r0230_weighted_interest_resi;
	private BigDecimal	r0230_total_loan_outstanding_resi;
	private BigDecimal	r0230_total_interest_income_resi;
	private BigDecimal	r0230_new_loan_in_month_nonresi;
	private BigDecimal	r0230_min_interest_rate_nonresi;
	private BigDecimal	r0230_max_interest_rate_nonresi;
	private BigDecimal	r0230_weighted_interest_nonresi;
	private BigDecimal	r0230_total_loan_outstanding_nonresi;
	private BigDecimal	r0230_total_interest_income_nonresi;
	private String	r0240_loantype;
	private BigDecimal	r0240_new_loan_in_month_resi;
	private BigDecimal	r0240_min_interest_rate_resi;
	private BigDecimal	r0240_max_interest_rate_resi;
	private BigDecimal	r0240_weighted_interest_resi;
	private BigDecimal	r0240_total_loan_outstanding_resi;
	private BigDecimal	r0240_total_interest_income_resi;
	private BigDecimal	r0240_new_loan_in_month_nonresi;
	private BigDecimal	r0240_min_interest_rate_nonresi;
	private BigDecimal	r0240_max_interest_rate_nonresi;
	private BigDecimal	r0240_weighted_interest_nonresi;
	private BigDecimal	r0240_total_loan_outstanding_nonresi;
	private BigDecimal	r0240_total_interest_income_nonresi;
	private String	r0250_loantype;
	private BigDecimal	r0250_new_loan_in_month_resi;
	private BigDecimal	r0250_min_interest_rate_resi;
	private BigDecimal	r0250_max_interest_rate_resi;
	private BigDecimal	r0250_weighted_interest_resi;
	private BigDecimal	r0250_total_loan_outstanding_resi;
	private BigDecimal	r0250_total_interest_income_resi;
	private BigDecimal	r0250_new_loan_in_month_nonresi;
	private BigDecimal	r0250_min_interest_rate_nonresi;
	private BigDecimal	r0250_max_interest_rate_nonresi;
	private BigDecimal	r0250_weighted_interest_nonresi;
	private BigDecimal	r0250_total_loan_outstanding_nonresi;
	private BigDecimal	r0250_total_interest_income_nonresi;
	private String	r0260_loantype;
	private BigDecimal	r0260_new_loan_in_month_resi;
	private BigDecimal	r0260_min_interest_rate_resi;
	private BigDecimal	r0260_max_interest_rate_resi;
	private BigDecimal	r0260_weighted_interest_resi;
	private BigDecimal	r0260_total_loan_outstanding_resi;
	private BigDecimal	r0260_total_interest_income_resi;
	private BigDecimal	r0260_new_loan_in_month_nonresi;
	private BigDecimal	r0260_min_interest_rate_nonresi;
	private BigDecimal	r0260_max_interest_rate_nonresi;
	private BigDecimal	r0260_weighted_interest_nonresi;
	private BigDecimal	r0260_total_loan_outstanding_nonresi;
	private BigDecimal	r0260_total_interest_income_nonresi;
	private String	r0270_loantype;
	private BigDecimal	r0270_new_loan_in_month_resi;
	private BigDecimal	r0270_min_interest_rate_resi;
	private BigDecimal	r0270_max_interest_rate_resi;
	private BigDecimal	r0270_weighted_interest_resi;
	private BigDecimal	r0270_total_loan_outstanding_resi;
	private BigDecimal	r0270_total_interest_income_resi;
	private BigDecimal	r0270_new_loan_in_month_nonresi;
	private BigDecimal	r0270_min_interest_rate_nonresi;
	private BigDecimal	r0270_max_interest_rate_nonresi;
	private BigDecimal	r0270_weighted_interest_nonresi;
	private BigDecimal	r0270_total_loan_outstanding_nonresi;
	private BigDecimal	r0270_total_interest_income_nonresi;
	private String	r0280_loantype;
	private BigDecimal	r0280_new_loan_in_month_resi;
	private BigDecimal	r0280_min_interest_rate_resi;
	private BigDecimal	r0280_max_interest_rate_resi;
	private BigDecimal	r0280_weighted_interest_resi;
	private BigDecimal	r0280_total_loan_outstanding_resi;
	private BigDecimal	r0280_total_interest_income_resi;
	private BigDecimal	r0280_new_loan_in_month_nonresi;
	private BigDecimal	r0280_min_interest_rate_nonresi;
	private BigDecimal	r0280_max_interest_rate_nonresi;
	private BigDecimal	r0280_weighted_interest_nonresi;
	private BigDecimal	r0280_total_loan_outstanding_nonresi;
	private BigDecimal	r0280_total_interest_income_nonresi;
	private String	r0290_loantype;
	private BigDecimal	r0290_new_loan_in_month_resi;
	private BigDecimal	r0290_min_interest_rate_resi;
	private BigDecimal	r0290_max_interest_rate_resi;
	private BigDecimal	r0290_weighted_interest_resi;
	private BigDecimal	r0290_total_loan_outstanding_resi;
	private BigDecimal	r0290_total_interest_income_resi;
	private BigDecimal	r0290_new_loan_in_month_nonresi;
	private BigDecimal	r0290_min_interest_rate_nonresi;
	private BigDecimal	r0290_max_interest_rate_nonresi;
	private BigDecimal	r0290_weighted_interest_nonresi;
	private BigDecimal	r0290_total_loan_outstanding_nonresi;
	private BigDecimal	r0290_total_interest_income_nonresi;
	private String	r0300_loantype;
	private BigDecimal	r0300_new_loan_in_month_resi;
	private BigDecimal	r0300_min_interest_rate_resi;
	private BigDecimal	r0300_max_interest_rate_resi;
	private BigDecimal	r0300_weighted_interest_resi;
	private BigDecimal	r0300_total_loan_outstanding_resi;
	private BigDecimal	r0300_total_interest_income_resi;
	private BigDecimal	r0300_new_loan_in_month_nonresi;
	private BigDecimal	r0300_min_interest_rate_nonresi;
	private BigDecimal	r0300_max_interest_rate_nonresi;
	private BigDecimal	r0300_weighted_interest_nonresi;
	private BigDecimal	r0300_total_loan_outstanding_nonresi;
	private BigDecimal	r0300_total_interest_income_nonresi;
	private String	r0310_loantype;
	private BigDecimal	r0310_new_loan_in_month_resi;
	private BigDecimal	r0310_min_interest_rate_resi;
	private BigDecimal	r0310_max_interest_rate_resi;
	private BigDecimal	r0310_weighted_interest_resi;
	private BigDecimal	r0310_total_loan_outstanding_resi;
	private BigDecimal	r0310_total_interest_income_resi;
	private BigDecimal	r0310_new_loan_in_month_nonresi;
	private BigDecimal	r0310_min_interest_rate_nonresi;
	private BigDecimal	r0310_max_interest_rate_nonresi;
	private BigDecimal	r0310_weighted_interest_nonresi;
	private BigDecimal	r0310_total_loan_outstanding_nonresi;
	private BigDecimal	r0310_total_interest_income_nonresi;
	private String	r0320_loantype;
	private BigDecimal	r0320_new_loan_in_month_resi;
	private BigDecimal	r0320_min_interest_rate_resi;
	private BigDecimal	r0320_max_interest_rate_resi;
	private BigDecimal	r0320_weighted_interest_resi;
	private BigDecimal	r0320_total_loan_outstanding_resi;
	private BigDecimal	r0320_total_interest_income_resi;
	private BigDecimal	r0320_new_loan_in_month_nonresi;
	private BigDecimal	r0320_min_interest_rate_nonresi;
	private BigDecimal	r0320_max_interest_rate_nonresi;
	private BigDecimal	r0320_weighted_interest_nonresi;
	private BigDecimal	r0320_total_loan_outstanding_nonresi;
	private BigDecimal	r0320_total_interest_income_nonresi;
	private String	r0330_loantype;
	private BigDecimal	r0330_new_loan_in_month_resi;
	private BigDecimal	r0330_min_interest_rate_resi;
	private BigDecimal	r0330_max_interest_rate_resi;
	private BigDecimal	r0330_weighted_interest_resi;
	private BigDecimal	r0330_total_loan_outstanding_resi;
	private BigDecimal	r0330_total_interest_income_resi;
	private BigDecimal	r0330_new_loan_in_month_nonresi;
	private BigDecimal	r0330_min_interest_rate_nonresi;
	private BigDecimal	r0330_max_interest_rate_nonresi;
	private BigDecimal	r0330_weighted_interest_nonresi;
	private BigDecimal	r0330_total_loan_outstanding_nonresi;
	private BigDecimal	r0330_total_interest_income_nonresi;
	private String	r0340_loantype;
	private String	r0350_loantype;
	private BigDecimal	r0350_new_loan_in_month_resi;
	private BigDecimal	r0350_min_interest_rate_resi;
	private BigDecimal	r0350_max_interest_rate_resi;
	private BigDecimal	r0350_weighted_interest_resi;
	private BigDecimal	r0350_total_loan_outstanding_resi;
	private BigDecimal	r0350_total_interest_income_resi;
	private BigDecimal	r0350_new_loan_in_month_nonresi;
	private BigDecimal	r0350_min_interest_rate_nonresi;
	private BigDecimal	r0350_max_interest_rate_nonresi;
	private BigDecimal	r0350_weighted_interest_nonresi;
	private BigDecimal	r0350_total_loan_outstanding_nonresi;
	private BigDecimal	r0350_total_interest_income_nonresi;
	private String	r0360_loantype;
	private BigDecimal	r0360_new_loan_in_month_resi;
	private BigDecimal	r0360_min_interest_rate_resi;
	private BigDecimal	r0360_max_interest_rate_resi;
	private BigDecimal	r0360_weighted_interest_resi;
	private BigDecimal	r0360_total_loan_outstanding_resi;
	private BigDecimal	r0360_total_interest_income_resi;
	private BigDecimal	r0360_new_loan_in_month_nonresi;
	private BigDecimal	r0360_min_interest_rate_nonresi;
	private BigDecimal	r0360_max_interest_rate_nonresi;
	private BigDecimal	r0360_weighted_interest_nonresi;
	private BigDecimal	r0360_total_loan_outstanding_nonresi;
	private BigDecimal	r0360_total_interest_income_nonresi;
	private String	r0370_loantype;
	private BigDecimal	r0370_new_loan_in_month_resi;
	private BigDecimal	r0370_min_interest_rate_resi;
	private BigDecimal	r0370_max_interest_rate_resi;
	private BigDecimal	r0370_weighted_interest_resi;
	private BigDecimal	r0370_total_loan_outstanding_resi;
	private BigDecimal	r0370_total_interest_income_resi;
	private BigDecimal	r0370_new_loan_in_month_nonresi;
	private BigDecimal	r0370_min_interest_rate_nonresi;
	private BigDecimal	r0370_max_interest_rate_nonresi;
	private BigDecimal	r0370_weighted_interest_nonresi;
	private BigDecimal	r0370_total_loan_outstanding_nonresi;
	private BigDecimal	r0370_total_interest_income_nonresi;
	private String	r0380_loantype;
	private BigDecimal	r0380_new_loan_in_month_resi;
	private BigDecimal	r0380_min_interest_rate_resi;
	private BigDecimal	r0380_max_interest_rate_resi;
	private BigDecimal	r0380_weighted_interest_resi;
	private BigDecimal	r0380_total_loan_outstanding_resi;
	private BigDecimal	r0380_total_interest_income_resi;
	private BigDecimal	r0380_new_loan_in_month_nonresi;
	private BigDecimal	r0380_min_interest_rate_nonresi;
	private BigDecimal	r0380_max_interest_rate_nonresi;
	private BigDecimal	r0380_weighted_interest_nonresi;
	private BigDecimal	r0380_total_loan_outstanding_nonresi;
	private BigDecimal	r0380_total_interest_income_nonresi;
	private String	r0390_loantype;
	private BigDecimal	r0390_new_loan_in_month_resi;
	private BigDecimal	r0390_min_interest_rate_resi;
	private BigDecimal	r0390_max_interest_rate_resi;
	private BigDecimal	r0390_weighted_interest_resi;
	private BigDecimal	r0390_total_loan_outstanding_resi;
	private BigDecimal	r0390_total_interest_income_resi;
	private BigDecimal	r0390_new_loan_in_month_nonresi;
	private BigDecimal	r0390_min_interest_rate_nonresi;
	private BigDecimal	r0390_max_interest_rate_nonresi;
	private BigDecimal	r0390_weighted_interest_nonresi;
	private BigDecimal	r0390_total_loan_outstanding_nonresi;
	private BigDecimal	r0390_total_interest_income_nonresi;
	private String	r0400_loantype;
	private BigDecimal	r0400_new_loan_in_month_resi;
	private BigDecimal	r0400_min_interest_rate_resi;
	private BigDecimal	r0400_max_interest_rate_resi;
	private BigDecimal	r0400_weighted_interest_resi;
	private BigDecimal	r0400_total_loan_outstanding_resi;
	private BigDecimal	r0400_total_interest_income_resi;
	private BigDecimal	r0400_new_loan_in_month_nonresi;
	private BigDecimal	r0400_min_interest_rate_nonresi;
	private BigDecimal	r0400_max_interest_rate_nonresi;
	private BigDecimal	r0400_weighted_interest_nonresi;
	private BigDecimal	r0400_total_loan_outstanding_nonresi;
	private BigDecimal	r0400_total_interest_income_nonresi;
	private String	r0410_loantype;
	private BigDecimal	r0410_new_loan_in_month_resi;
	private BigDecimal	r0410_min_interest_rate_resi;
	private BigDecimal	r0410_max_interest_rate_resi;
	private BigDecimal	r0410_weighted_interest_resi;
	private BigDecimal	r0410_total_loan_outstanding_resi;
	private BigDecimal	r0410_total_interest_income_resi;
	private BigDecimal	r0410_new_loan_in_month_nonresi;
	private BigDecimal	r0410_min_interest_rate_nonresi;
	private BigDecimal	r0410_max_interest_rate_nonresi;
	private BigDecimal	r0410_weighted_interest_nonresi;
	private BigDecimal	r0410_total_loan_outstanding_nonresi;
	private BigDecimal	r0410_total_interest_income_nonresi;
	private String	r0420_loantype;
	private BigDecimal	r0420_new_loan_in_month_resi;
	private BigDecimal	r0420_min_interest_rate_resi;
	private BigDecimal	r0420_max_interest_rate_resi;
	private BigDecimal	r0420_weighted_interest_resi;
	private BigDecimal	r0420_total_loan_outstanding_resi;
	private BigDecimal	r0420_total_interest_income_resi;
	private BigDecimal	r0420_new_loan_in_month_nonresi;
	private BigDecimal	r0420_min_interest_rate_nonresi;
	private BigDecimal	r0420_max_interest_rate_nonresi;
	private BigDecimal	r0420_weighted_interest_nonresi;
	private BigDecimal	r0420_total_loan_outstanding_nonresi;
	private BigDecimal	r0420_total_interest_income_nonresi;
	private String	r0430_loantype;
	private BigDecimal	r0430_new_loan_in_month_resi;
	private BigDecimal	r0430_min_interest_rate_resi;
	private BigDecimal	r0430_max_interest_rate_resi;
	private BigDecimal	r0430_weighted_interest_resi;
	private BigDecimal	r0430_total_loan_outstanding_resi;
	private BigDecimal	r0430_total_interest_income_resi;
	private BigDecimal	r0430_new_loan_in_month_nonresi;
	private BigDecimal	r0430_min_interest_rate_nonresi;
	private BigDecimal	r0430_max_interest_rate_nonresi;
	private BigDecimal	r0430_weighted_interest_nonresi;
	private BigDecimal	r0430_total_loan_outstanding_nonresi;
	private BigDecimal	r0430_total_interest_income_nonresi;
	private String	r0440_loantype;
	private BigDecimal	r0440_new_loan_in_month_resi;
	private BigDecimal	r0440_min_interest_rate_resi;
	private BigDecimal	r0440_max_interest_rate_resi;
	private BigDecimal	r0440_weighted_interest_resi;
	private BigDecimal	r0440_total_loan_outstanding_resi;
	private BigDecimal	r0440_total_interest_income_resi;
	private BigDecimal	r0440_new_loan_in_month_nonresi;
	private BigDecimal	r0440_min_interest_rate_nonresi;
	private BigDecimal	r0440_max_interest_rate_nonresi;
	private BigDecimal	r0440_weighted_interest_nonresi;
	private BigDecimal	r0440_total_loan_outstanding_nonresi;
	private BigDecimal	r0440_total_interest_income_nonresi;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date	report_date;
	private String	report_version;
	private String	report_frequency;
	private String	report_code;
	private String	report_desc;
	private String	modify_flg;
	private String	entity_flg;
	
	
	
	public String getR0010_loantype() {
		return r0010_loantype;
	}
	public void setR0010_loantype(String r0010_loantype) {
		this.r0010_loantype = r0010_loantype;
	}
	public String getR0020_loantype() {
		return r0020_loantype;
	}
	public void setR0020_loantype(String r0020_loantype) {
		this.r0020_loantype = r0020_loantype;
	}
	public String getR0030_loantype() {
		return r0030_loantype;
	}
	public void setR0030_loantype(String r0030_loantype) {
		this.r0030_loantype = r0030_loantype;
	}
	public BigDecimal getR0030_new_loan_in_month_resi() {
		return r0030_new_loan_in_month_resi;
	}
	public void setR0030_new_loan_in_month_resi(BigDecimal r0030_new_loan_in_month_resi) {
		this.r0030_new_loan_in_month_resi = r0030_new_loan_in_month_resi;
	}
	public BigDecimal getR0030_min_interest_rate_resi() {
		return r0030_min_interest_rate_resi;
	}
	public void setR0030_min_interest_rate_resi(BigDecimal r0030_min_interest_rate_resi) {
		this.r0030_min_interest_rate_resi = r0030_min_interest_rate_resi;
	}
	public BigDecimal getR0030_max_interest_rate_resi() {
		return r0030_max_interest_rate_resi;
	}
	public void setR0030_max_interest_rate_resi(BigDecimal r0030_max_interest_rate_resi) {
		this.r0030_max_interest_rate_resi = r0030_max_interest_rate_resi;
	}
	public BigDecimal getR0030_weighted_interest_resi() {
		return r0030_weighted_interest_resi;
	}
	public void setR0030_weighted_interest_resi(BigDecimal r0030_weighted_interest_resi) {
		this.r0030_weighted_interest_resi = r0030_weighted_interest_resi;
	}
	public BigDecimal getR0030_total_loan_outstanding_resi() {
		return r0030_total_loan_outstanding_resi;
	}
	public void setR0030_total_loan_outstanding_resi(BigDecimal r0030_total_loan_outstanding_resi) {
		this.r0030_total_loan_outstanding_resi = r0030_total_loan_outstanding_resi;
	}
	public BigDecimal getR0030_total_interest_income_resi() {
		return r0030_total_interest_income_resi;
	}
	public void setR0030_total_interest_income_resi(BigDecimal r0030_total_interest_income_resi) {
		this.r0030_total_interest_income_resi = r0030_total_interest_income_resi;
	}
	public BigDecimal getR0030_new_loan_in_month_nonresi() {
		return r0030_new_loan_in_month_nonresi;
	}
	public void setR0030_new_loan_in_month_nonresi(BigDecimal r0030_new_loan_in_month_nonresi) {
		this.r0030_new_loan_in_month_nonresi = r0030_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0030_min_interest_rate_nonresi() {
		return r0030_min_interest_rate_nonresi;
	}
	public void setR0030_min_interest_rate_nonresi(BigDecimal r0030_min_interest_rate_nonresi) {
		this.r0030_min_interest_rate_nonresi = r0030_min_interest_rate_nonresi;
	}
	public BigDecimal getR0030_max_interest_rate_nonresi() {
		return r0030_max_interest_rate_nonresi;
	}
	public void setR0030_max_interest_rate_nonresi(BigDecimal r0030_max_interest_rate_nonresi) {
		this.r0030_max_interest_rate_nonresi = r0030_max_interest_rate_nonresi;
	}
	public BigDecimal getR0030_weighted_interest_nonresi() {
		return r0030_weighted_interest_nonresi;
	}
	public void setR0030_weighted_interest_nonresi(BigDecimal r0030_weighted_interest_nonresi) {
		this.r0030_weighted_interest_nonresi = r0030_weighted_interest_nonresi;
	}
	public BigDecimal getR0030_total_loan_outstanding_nonresi() {
		return r0030_total_loan_outstanding_nonresi;
	}
	public void setR0030_total_loan_outstanding_nonresi(BigDecimal r0030_total_loan_outstanding_nonresi) {
		this.r0030_total_loan_outstanding_nonresi = r0030_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0030_total_interest_income_nonresi() {
		return r0030_total_interest_income_nonresi;
	}
	public void setR0030_total_interest_income_nonresi(BigDecimal r0030_total_interest_income_nonresi) {
		this.r0030_total_interest_income_nonresi = r0030_total_interest_income_nonresi;
	}
	public String getR0040_loantype() {
		return r0040_loantype;
	}
	public void setR0040_loantype(String r0040_loantype) {
		this.r0040_loantype = r0040_loantype;
	}
	public BigDecimal getR0040_new_loan_in_month_resi() {
		return r0040_new_loan_in_month_resi;
	}
	public void setR0040_new_loan_in_month_resi(BigDecimal r0040_new_loan_in_month_resi) {
		this.r0040_new_loan_in_month_resi = r0040_new_loan_in_month_resi;
	}
	public BigDecimal getR0040_min_interest_rate_resi() {
		return r0040_min_interest_rate_resi;
	}
	public void setR0040_min_interest_rate_resi(BigDecimal r0040_min_interest_rate_resi) {
		this.r0040_min_interest_rate_resi = r0040_min_interest_rate_resi;
	}
	public BigDecimal getR0040_max_interest_rate_resi() {
		return r0040_max_interest_rate_resi;
	}
	public void setR0040_max_interest_rate_resi(BigDecimal r0040_max_interest_rate_resi) {
		this.r0040_max_interest_rate_resi = r0040_max_interest_rate_resi;
	}
	public BigDecimal getR0040_weighted_interest_resi() {
		return r0040_weighted_interest_resi;
	}
	public void setR0040_weighted_interest_resi(BigDecimal r0040_weighted_interest_resi) {
		this.r0040_weighted_interest_resi = r0040_weighted_interest_resi;
	}
	public BigDecimal getR0040_total_loan_outstanding_resi() {
		return r0040_total_loan_outstanding_resi;
	}
	public void setR0040_total_loan_outstanding_resi(BigDecimal r0040_total_loan_outstanding_resi) {
		this.r0040_total_loan_outstanding_resi = r0040_total_loan_outstanding_resi;
	}
	public BigDecimal getR0040_total_interest_income_resi() {
		return r0040_total_interest_income_resi;
	}
	public void setR0040_total_interest_income_resi(BigDecimal r0040_total_interest_income_resi) {
		this.r0040_total_interest_income_resi = r0040_total_interest_income_resi;
	}
	public BigDecimal getR0040_new_loan_in_month_nonresi() {
		return r0040_new_loan_in_month_nonresi;
	}
	public void setR0040_new_loan_in_month_nonresi(BigDecimal r0040_new_loan_in_month_nonresi) {
		this.r0040_new_loan_in_month_nonresi = r0040_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0040_min_interest_rate_nonresi() {
		return r0040_min_interest_rate_nonresi;
	}
	public void setR0040_min_interest_rate_nonresi(BigDecimal r0040_min_interest_rate_nonresi) {
		this.r0040_min_interest_rate_nonresi = r0040_min_interest_rate_nonresi;
	}
	public BigDecimal getR0040_max_interest_rate_nonresi() {
		return r0040_max_interest_rate_nonresi;
	}
	public void setR0040_max_interest_rate_nonresi(BigDecimal r0040_max_interest_rate_nonresi) {
		this.r0040_max_interest_rate_nonresi = r0040_max_interest_rate_nonresi;
	}
	public BigDecimal getR0040_weighted_interest_nonresi() {
		return r0040_weighted_interest_nonresi;
	}
	public void setR0040_weighted_interest_nonresi(BigDecimal r0040_weighted_interest_nonresi) {
		this.r0040_weighted_interest_nonresi = r0040_weighted_interest_nonresi;
	}
	public BigDecimal getR0040_total_loan_outstanding_nonresi() {
		return r0040_total_loan_outstanding_nonresi;
	}
	public void setR0040_total_loan_outstanding_nonresi(BigDecimal r0040_total_loan_outstanding_nonresi) {
		this.r0040_total_loan_outstanding_nonresi = r0040_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0040_total_interest_income_nonresi() {
		return r0040_total_interest_income_nonresi;
	}
	public void setR0040_total_interest_income_nonresi(BigDecimal r0040_total_interest_income_nonresi) {
		this.r0040_total_interest_income_nonresi = r0040_total_interest_income_nonresi;
	}
	public String getR0050_loantype() {
		return r0050_loantype;
	}
	public void setR0050_loantype(String r0050_loantype) {
		this.r0050_loantype = r0050_loantype;
	}
	public BigDecimal getR0050_new_loan_in_month_resi() {
		return r0050_new_loan_in_month_resi;
	}
	public void setR0050_new_loan_in_month_resi(BigDecimal r0050_new_loan_in_month_resi) {
		this.r0050_new_loan_in_month_resi = r0050_new_loan_in_month_resi;
	}
	public BigDecimal getR0050_min_interest_rate_resi() {
		return r0050_min_interest_rate_resi;
	}
	public void setR0050_min_interest_rate_resi(BigDecimal r0050_min_interest_rate_resi) {
		this.r0050_min_interest_rate_resi = r0050_min_interest_rate_resi;
	}
	public BigDecimal getR0050_max_interest_rate_resi() {
		return r0050_max_interest_rate_resi;
	}
	public void setR0050_max_interest_rate_resi(BigDecimal r0050_max_interest_rate_resi) {
		this.r0050_max_interest_rate_resi = r0050_max_interest_rate_resi;
	}
	public BigDecimal getR0050_weighted_interest_resi() {
		return r0050_weighted_interest_resi;
	}
	public void setR0050_weighted_interest_resi(BigDecimal r0050_weighted_interest_resi) {
		this.r0050_weighted_interest_resi = r0050_weighted_interest_resi;
	}
	public BigDecimal getR0050_total_loan_outstanding_resi() {
		return r0050_total_loan_outstanding_resi;
	}
	public void setR0050_total_loan_outstanding_resi(BigDecimal r0050_total_loan_outstanding_resi) {
		this.r0050_total_loan_outstanding_resi = r0050_total_loan_outstanding_resi;
	}
	public BigDecimal getR0050_total_interest_income_resi() {
		return r0050_total_interest_income_resi;
	}
	public void setR0050_total_interest_income_resi(BigDecimal r0050_total_interest_income_resi) {
		this.r0050_total_interest_income_resi = r0050_total_interest_income_resi;
	}
	public BigDecimal getR0050_new_loan_in_month_nonresi() {
		return r0050_new_loan_in_month_nonresi;
	}
	public void setR0050_new_loan_in_month_nonresi(BigDecimal r0050_new_loan_in_month_nonresi) {
		this.r0050_new_loan_in_month_nonresi = r0050_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0050_min_interest_rate_nonresi() {
		return r0050_min_interest_rate_nonresi;
	}
	public void setR0050_min_interest_rate_nonresi(BigDecimal r0050_min_interest_rate_nonresi) {
		this.r0050_min_interest_rate_nonresi = r0050_min_interest_rate_nonresi;
	}
	public BigDecimal getR0050_max_interest_rate_nonresi() {
		return r0050_max_interest_rate_nonresi;
	}
	public void setR0050_max_interest_rate_nonresi(BigDecimal r0050_max_interest_rate_nonresi) {
		this.r0050_max_interest_rate_nonresi = r0050_max_interest_rate_nonresi;
	}
	public BigDecimal getR0050_weighted_interest_nonresi() {
		return r0050_weighted_interest_nonresi;
	}
	public void setR0050_weighted_interest_nonresi(BigDecimal r0050_weighted_interest_nonresi) {
		this.r0050_weighted_interest_nonresi = r0050_weighted_interest_nonresi;
	}
	public BigDecimal getR0050_total_loan_outstanding_nonresi() {
		return r0050_total_loan_outstanding_nonresi;
	}
	public void setR0050_total_loan_outstanding_nonresi(BigDecimal r0050_total_loan_outstanding_nonresi) {
		this.r0050_total_loan_outstanding_nonresi = r0050_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0050_total_interest_income_nonresi() {
		return r0050_total_interest_income_nonresi;
	}
	public void setR0050_total_interest_income_nonresi(BigDecimal r0050_total_interest_income_nonresi) {
		this.r0050_total_interest_income_nonresi = r0050_total_interest_income_nonresi;
	}
	public String getR0060_loantype() {
		return r0060_loantype;
	}
	public void setR0060_loantype(String r0060_loantype) {
		this.r0060_loantype = r0060_loantype;
	}
	public String getR0070_loantype() {
		return r0070_loantype;
	}
	public void setR0070_loantype(String r0070_loantype) {
		this.r0070_loantype = r0070_loantype;
	}
	public BigDecimal getR0070_new_loan_in_month_resi() {
		return r0070_new_loan_in_month_resi;
	}
	public void setR0070_new_loan_in_month_resi(BigDecimal r0070_new_loan_in_month_resi) {
		this.r0070_new_loan_in_month_resi = r0070_new_loan_in_month_resi;
	}
	public BigDecimal getR0070_min_interest_rate_resi() {
		return r0070_min_interest_rate_resi;
	}
	public void setR0070_min_interest_rate_resi(BigDecimal r0070_min_interest_rate_resi) {
		this.r0070_min_interest_rate_resi = r0070_min_interest_rate_resi;
	}
	public BigDecimal getR0070_max_interest_rate_resi() {
		return r0070_max_interest_rate_resi;
	}
	public void setR0070_max_interest_rate_resi(BigDecimal r0070_max_interest_rate_resi) {
		this.r0070_max_interest_rate_resi = r0070_max_interest_rate_resi;
	}
	public BigDecimal getR0070_weighted_interest_resi() {
		return r0070_weighted_interest_resi;
	}
	public void setR0070_weighted_interest_resi(BigDecimal r0070_weighted_interest_resi) {
		this.r0070_weighted_interest_resi = r0070_weighted_interest_resi;
	}
	public BigDecimal getR0070_total_loan_outstanding_resi() {
		return r0070_total_loan_outstanding_resi;
	}
	public void setR0070_total_loan_outstanding_resi(BigDecimal r0070_total_loan_outstanding_resi) {
		this.r0070_total_loan_outstanding_resi = r0070_total_loan_outstanding_resi;
	}
	public BigDecimal getR0070_total_interest_income_resi() {
		return r0070_total_interest_income_resi;
	}
	public void setR0070_total_interest_income_resi(BigDecimal r0070_total_interest_income_resi) {
		this.r0070_total_interest_income_resi = r0070_total_interest_income_resi;
	}
	public BigDecimal getR0070_new_loan_in_month_nonresi() {
		return r0070_new_loan_in_month_nonresi;
	}
	public void setR0070_new_loan_in_month_nonresi(BigDecimal r0070_new_loan_in_month_nonresi) {
		this.r0070_new_loan_in_month_nonresi = r0070_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0070_min_interest_rate_nonresi() {
		return r0070_min_interest_rate_nonresi;
	}
	public void setR0070_min_interest_rate_nonresi(BigDecimal r0070_min_interest_rate_nonresi) {
		this.r0070_min_interest_rate_nonresi = r0070_min_interest_rate_nonresi;
	}
	public BigDecimal getR0070_max_interest_rate_nonresi() {
		return r0070_max_interest_rate_nonresi;
	}
	public void setR0070_max_interest_rate_nonresi(BigDecimal r0070_max_interest_rate_nonresi) {
		this.r0070_max_interest_rate_nonresi = r0070_max_interest_rate_nonresi;
	}
	public BigDecimal getR0070_weighted_interest_nonresi() {
		return r0070_weighted_interest_nonresi;
	}
	public void setR0070_weighted_interest_nonresi(BigDecimal r0070_weighted_interest_nonresi) {
		this.r0070_weighted_interest_nonresi = r0070_weighted_interest_nonresi;
	}
	public BigDecimal getR0070_total_loan_outstanding_nonresi() {
		return r0070_total_loan_outstanding_nonresi;
	}
	public void setR0070_total_loan_outstanding_nonresi(BigDecimal r0070_total_loan_outstanding_nonresi) {
		this.r0070_total_loan_outstanding_nonresi = r0070_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0070_total_interest_income_nonresi() {
		return r0070_total_interest_income_nonresi;
	}
	public void setR0070_total_interest_income_nonresi(BigDecimal r0070_total_interest_income_nonresi) {
		this.r0070_total_interest_income_nonresi = r0070_total_interest_income_nonresi;
	}
	public String getR0080_loantype() {
		return r0080_loantype;
	}
	public void setR0080_loantype(String r0080_loantype) {
		this.r0080_loantype = r0080_loantype;
	}
	public BigDecimal getR0080_new_loan_in_month_resi() {
		return r0080_new_loan_in_month_resi;
	}
	public void setR0080_new_loan_in_month_resi(BigDecimal r0080_new_loan_in_month_resi) {
		this.r0080_new_loan_in_month_resi = r0080_new_loan_in_month_resi;
	}
	public BigDecimal getR0080_min_interest_rate_resi() {
		return r0080_min_interest_rate_resi;
	}
	public void setR0080_min_interest_rate_resi(BigDecimal r0080_min_interest_rate_resi) {
		this.r0080_min_interest_rate_resi = r0080_min_interest_rate_resi;
	}
	public BigDecimal getR0080_max_interest_rate_resi() {
		return r0080_max_interest_rate_resi;
	}
	public void setR0080_max_interest_rate_resi(BigDecimal r0080_max_interest_rate_resi) {
		this.r0080_max_interest_rate_resi = r0080_max_interest_rate_resi;
	}
	public BigDecimal getR0080_weighted_interest_resi() {
		return r0080_weighted_interest_resi;
	}
	public void setR0080_weighted_interest_resi(BigDecimal r0080_weighted_interest_resi) {
		this.r0080_weighted_interest_resi = r0080_weighted_interest_resi;
	}
	public BigDecimal getR0080_total_loan_outstanding_resi() {
		return r0080_total_loan_outstanding_resi;
	}
	public void setR0080_total_loan_outstanding_resi(BigDecimal r0080_total_loan_outstanding_resi) {
		this.r0080_total_loan_outstanding_resi = r0080_total_loan_outstanding_resi;
	}
	public BigDecimal getR0080_total_interest_income_resi() {
		return r0080_total_interest_income_resi;
	}
	public void setR0080_total_interest_income_resi(BigDecimal r0080_total_interest_income_resi) {
		this.r0080_total_interest_income_resi = r0080_total_interest_income_resi;
	}
	public BigDecimal getR0080_new_loan_in_month_nonresi() {
		return r0080_new_loan_in_month_nonresi;
	}
	public void setR0080_new_loan_in_month_nonresi(BigDecimal r0080_new_loan_in_month_nonresi) {
		this.r0080_new_loan_in_month_nonresi = r0080_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0080_min_interest_rate_nonresi() {
		return r0080_min_interest_rate_nonresi;
	}
	public void setR0080_min_interest_rate_nonresi(BigDecimal r0080_min_interest_rate_nonresi) {
		this.r0080_min_interest_rate_nonresi = r0080_min_interest_rate_nonresi;
	}
	public BigDecimal getR0080_max_interest_rate_nonresi() {
		return r0080_max_interest_rate_nonresi;
	}
	public void setR0080_max_interest_rate_nonresi(BigDecimal r0080_max_interest_rate_nonresi) {
		this.r0080_max_interest_rate_nonresi = r0080_max_interest_rate_nonresi;
	}
	public BigDecimal getR0080_weighted_interest_nonresi() {
		return r0080_weighted_interest_nonresi;
	}
	public void setR0080_weighted_interest_nonresi(BigDecimal r0080_weighted_interest_nonresi) {
		this.r0080_weighted_interest_nonresi = r0080_weighted_interest_nonresi;
	}
	public BigDecimal getR0080_total_loan_outstanding_nonresi() {
		return r0080_total_loan_outstanding_nonresi;
	}
	public void setR0080_total_loan_outstanding_nonresi(BigDecimal r0080_total_loan_outstanding_nonresi) {
		this.r0080_total_loan_outstanding_nonresi = r0080_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0080_total_interest_income_nonresi() {
		return r0080_total_interest_income_nonresi;
	}
	public void setR0080_total_interest_income_nonresi(BigDecimal r0080_total_interest_income_nonresi) {
		this.r0080_total_interest_income_nonresi = r0080_total_interest_income_nonresi;
	}
	public String getR0090_loantype() {
		return r0090_loantype;
	}
	public void setR0090_loantype(String r0090_loantype) {
		this.r0090_loantype = r0090_loantype;
	}
	public BigDecimal getR0090_new_loan_in_month_resi() {
		return r0090_new_loan_in_month_resi;
	}
	public void setR0090_new_loan_in_month_resi(BigDecimal r0090_new_loan_in_month_resi) {
		this.r0090_new_loan_in_month_resi = r0090_new_loan_in_month_resi;
	}
	public BigDecimal getR0090_min_interest_rate_resi() {
		return r0090_min_interest_rate_resi;
	}
	public void setR0090_min_interest_rate_resi(BigDecimal r0090_min_interest_rate_resi) {
		this.r0090_min_interest_rate_resi = r0090_min_interest_rate_resi;
	}
	public BigDecimal getR0090_max_interest_rate_resi() {
		return r0090_max_interest_rate_resi;
	}
	public void setR0090_max_interest_rate_resi(BigDecimal r0090_max_interest_rate_resi) {
		this.r0090_max_interest_rate_resi = r0090_max_interest_rate_resi;
	}
	public BigDecimal getR0090_weighted_interest_resi() {
		return r0090_weighted_interest_resi;
	}
	public void setR0090_weighted_interest_resi(BigDecimal r0090_weighted_interest_resi) {
		this.r0090_weighted_interest_resi = r0090_weighted_interest_resi;
	}
	public BigDecimal getR0090_total_loan_outstanding_resi() {
		return r0090_total_loan_outstanding_resi;
	}
	public void setR0090_total_loan_outstanding_resi(BigDecimal r0090_total_loan_outstanding_resi) {
		this.r0090_total_loan_outstanding_resi = r0090_total_loan_outstanding_resi;
	}
	public BigDecimal getR0090_total_interest_income_resi() {
		return r0090_total_interest_income_resi;
	}
	public void setR0090_total_interest_income_resi(BigDecimal r0090_total_interest_income_resi) {
		this.r0090_total_interest_income_resi = r0090_total_interest_income_resi;
	}
	public BigDecimal getR0090_new_loan_in_month_nonresi() {
		return r0090_new_loan_in_month_nonresi;
	}
	public void setR0090_new_loan_in_month_nonresi(BigDecimal r0090_new_loan_in_month_nonresi) {
		this.r0090_new_loan_in_month_nonresi = r0090_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0090_min_interest_rate_nonresi() {
		return r0090_min_interest_rate_nonresi;
	}
	public void setR0090_min_interest_rate_nonresi(BigDecimal r0090_min_interest_rate_nonresi) {
		this.r0090_min_interest_rate_nonresi = r0090_min_interest_rate_nonresi;
	}
	public BigDecimal getR0090_max_interest_rate_nonresi() {
		return r0090_max_interest_rate_nonresi;
	}
	public void setR0090_max_interest_rate_nonresi(BigDecimal r0090_max_interest_rate_nonresi) {
		this.r0090_max_interest_rate_nonresi = r0090_max_interest_rate_nonresi;
	}
	public BigDecimal getR0090_weighted_interest_nonresi() {
		return r0090_weighted_interest_nonresi;
	}
	public void setR0090_weighted_interest_nonresi(BigDecimal r0090_weighted_interest_nonresi) {
		this.r0090_weighted_interest_nonresi = r0090_weighted_interest_nonresi;
	}
	public BigDecimal getR0090_total_loan_outstanding_nonresi() {
		return r0090_total_loan_outstanding_nonresi;
	}
	public void setR0090_total_loan_outstanding_nonresi(BigDecimal r0090_total_loan_outstanding_nonresi) {
		this.r0090_total_loan_outstanding_nonresi = r0090_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0090_total_interest_income_nonresi() {
		return r0090_total_interest_income_nonresi;
	}
	public void setR0090_total_interest_income_nonresi(BigDecimal r0090_total_interest_income_nonresi) {
		this.r0090_total_interest_income_nonresi = r0090_total_interest_income_nonresi;
	}
	public String getR0100_loantype() {
		return r0100_loantype;
	}
	public void setR0100_loantype(String r0100_loantype) {
		this.r0100_loantype = r0100_loantype;
	}
	public BigDecimal getR0100_new_loan_in_month_resi() {
		return r0100_new_loan_in_month_resi;
	}
	public void setR0100_new_loan_in_month_resi(BigDecimal r0100_new_loan_in_month_resi) {
		this.r0100_new_loan_in_month_resi = r0100_new_loan_in_month_resi;
	}
	public BigDecimal getR0100_min_interest_rate_resi() {
		return r0100_min_interest_rate_resi;
	}
	public void setR0100_min_interest_rate_resi(BigDecimal r0100_min_interest_rate_resi) {
		this.r0100_min_interest_rate_resi = r0100_min_interest_rate_resi;
	}
	public BigDecimal getR0100_max_interest_rate_resi() {
		return r0100_max_interest_rate_resi;
	}
	public void setR0100_max_interest_rate_resi(BigDecimal r0100_max_interest_rate_resi) {
		this.r0100_max_interest_rate_resi = r0100_max_interest_rate_resi;
	}
	public BigDecimal getR0100_weighted_interest_resi() {
		return r0100_weighted_interest_resi;
	}
	public void setR0100_weighted_interest_resi(BigDecimal r0100_weighted_interest_resi) {
		this.r0100_weighted_interest_resi = r0100_weighted_interest_resi;
	}
	public BigDecimal getR0100_total_loan_outstanding_resi() {
		return r0100_total_loan_outstanding_resi;
	}
	public void setR0100_total_loan_outstanding_resi(BigDecimal r0100_total_loan_outstanding_resi) {
		this.r0100_total_loan_outstanding_resi = r0100_total_loan_outstanding_resi;
	}
	public BigDecimal getR0100_total_interest_income_resi() {
		return r0100_total_interest_income_resi;
	}
	public void setR0100_total_interest_income_resi(BigDecimal r0100_total_interest_income_resi) {
		this.r0100_total_interest_income_resi = r0100_total_interest_income_resi;
	}
	public BigDecimal getR0100_new_loan_in_month_nonresi() {
		return r0100_new_loan_in_month_nonresi;
	}
	public void setR0100_new_loan_in_month_nonresi(BigDecimal r0100_new_loan_in_month_nonresi) {
		this.r0100_new_loan_in_month_nonresi = r0100_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0100_min_interest_rate_nonresi() {
		return r0100_min_interest_rate_nonresi;
	}
	public void setR0100_min_interest_rate_nonresi(BigDecimal r0100_min_interest_rate_nonresi) {
		this.r0100_min_interest_rate_nonresi = r0100_min_interest_rate_nonresi;
	}
	public BigDecimal getR0100_max_interest_rate_nonresi() {
		return r0100_max_interest_rate_nonresi;
	}
	public void setR0100_max_interest_rate_nonresi(BigDecimal r0100_max_interest_rate_nonresi) {
		this.r0100_max_interest_rate_nonresi = r0100_max_interest_rate_nonresi;
	}
	public BigDecimal getR0100_weighted_interest_nonresi() {
		return r0100_weighted_interest_nonresi;
	}
	public void setR0100_weighted_interest_nonresi(BigDecimal r0100_weighted_interest_nonresi) {
		this.r0100_weighted_interest_nonresi = r0100_weighted_interest_nonresi;
	}
	public BigDecimal getR0100_total_loan_outstanding_nonresi() {
		return r0100_total_loan_outstanding_nonresi;
	}
	public void setR0100_total_loan_outstanding_nonresi(BigDecimal r0100_total_loan_outstanding_nonresi) {
		this.r0100_total_loan_outstanding_nonresi = r0100_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0100_total_interest_income_nonresi() {
		return r0100_total_interest_income_nonresi;
	}
	public void setR0100_total_interest_income_nonresi(BigDecimal r0100_total_interest_income_nonresi) {
		this.r0100_total_interest_income_nonresi = r0100_total_interest_income_nonresi;
	}
	public String getR0110_loantype() {
		return r0110_loantype;
	}
	public void setR0110_loantype(String r0110_loantype) {
		this.r0110_loantype = r0110_loantype;
	}
	public BigDecimal getR0110_new_loan_in_month_resi() {
		return r0110_new_loan_in_month_resi;
	}
	public void setR0110_new_loan_in_month_resi(BigDecimal r0110_new_loan_in_month_resi) {
		this.r0110_new_loan_in_month_resi = r0110_new_loan_in_month_resi;
	}
	public BigDecimal getR0110_min_interest_rate_resi() {
		return r0110_min_interest_rate_resi;
	}
	public void setR0110_min_interest_rate_resi(BigDecimal r0110_min_interest_rate_resi) {
		this.r0110_min_interest_rate_resi = r0110_min_interest_rate_resi;
	}
	public BigDecimal getR0110_max_interest_rate_resi() {
		return r0110_max_interest_rate_resi;
	}
	public void setR0110_max_interest_rate_resi(BigDecimal r0110_max_interest_rate_resi) {
		this.r0110_max_interest_rate_resi = r0110_max_interest_rate_resi;
	}
	public BigDecimal getR0110_weighted_interest_resi() {
		return r0110_weighted_interest_resi;
	}
	public void setR0110_weighted_interest_resi(BigDecimal r0110_weighted_interest_resi) {
		this.r0110_weighted_interest_resi = r0110_weighted_interest_resi;
	}
	public BigDecimal getR0110_total_loan_outstanding_resi() {
		return r0110_total_loan_outstanding_resi;
	}
	public void setR0110_total_loan_outstanding_resi(BigDecimal r0110_total_loan_outstanding_resi) {
		this.r0110_total_loan_outstanding_resi = r0110_total_loan_outstanding_resi;
	}
	public BigDecimal getR0110_total_interest_income_resi() {
		return r0110_total_interest_income_resi;
	}
	public void setR0110_total_interest_income_resi(BigDecimal r0110_total_interest_income_resi) {
		this.r0110_total_interest_income_resi = r0110_total_interest_income_resi;
	}
	public BigDecimal getR0110_new_loan_in_month_nonresi() {
		return r0110_new_loan_in_month_nonresi;
	}
	public void setR0110_new_loan_in_month_nonresi(BigDecimal r0110_new_loan_in_month_nonresi) {
		this.r0110_new_loan_in_month_nonresi = r0110_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0110_min_interest_rate_nonresi() {
		return r0110_min_interest_rate_nonresi;
	}
	public void setR0110_min_interest_rate_nonresi(BigDecimal r0110_min_interest_rate_nonresi) {
		this.r0110_min_interest_rate_nonresi = r0110_min_interest_rate_nonresi;
	}
	public BigDecimal getR0110_max_interest_rate_nonresi() {
		return r0110_max_interest_rate_nonresi;
	}
	public void setR0110_max_interest_rate_nonresi(BigDecimal r0110_max_interest_rate_nonresi) {
		this.r0110_max_interest_rate_nonresi = r0110_max_interest_rate_nonresi;
	}
	public BigDecimal getR0110_weighted_interest_nonresi() {
		return r0110_weighted_interest_nonresi;
	}
	public void setR0110_weighted_interest_nonresi(BigDecimal r0110_weighted_interest_nonresi) {
		this.r0110_weighted_interest_nonresi = r0110_weighted_interest_nonresi;
	}
	public BigDecimal getR0110_total_loan_outstanding_nonresi() {
		return r0110_total_loan_outstanding_nonresi;
	}
	public void setR0110_total_loan_outstanding_nonresi(BigDecimal r0110_total_loan_outstanding_nonresi) {
		this.r0110_total_loan_outstanding_nonresi = r0110_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0110_total_interest_income_nonresi() {
		return r0110_total_interest_income_nonresi;
	}
	public void setR0110_total_interest_income_nonresi(BigDecimal r0110_total_interest_income_nonresi) {
		this.r0110_total_interest_income_nonresi = r0110_total_interest_income_nonresi;
	}
	public String getR0120_loantype() {
		return r0120_loantype;
	}
	public void setR0120_loantype(String r0120_loantype) {
		this.r0120_loantype = r0120_loantype;
	}
	public BigDecimal getR0120_new_loan_in_month_resi() {
		return r0120_new_loan_in_month_resi;
	}
	public void setR0120_new_loan_in_month_resi(BigDecimal r0120_new_loan_in_month_resi) {
		this.r0120_new_loan_in_month_resi = r0120_new_loan_in_month_resi;
	}
	public BigDecimal getR0120_min_interest_rate_resi() {
		return r0120_min_interest_rate_resi;
	}
	public void setR0120_min_interest_rate_resi(BigDecimal r0120_min_interest_rate_resi) {
		this.r0120_min_interest_rate_resi = r0120_min_interest_rate_resi;
	}
	public BigDecimal getR0120_max_interest_rate_resi() {
		return r0120_max_interest_rate_resi;
	}
	public void setR0120_max_interest_rate_resi(BigDecimal r0120_max_interest_rate_resi) {
		this.r0120_max_interest_rate_resi = r0120_max_interest_rate_resi;
	}
	public BigDecimal getR0120_weighted_interest_resi() {
		return r0120_weighted_interest_resi;
	}
	public void setR0120_weighted_interest_resi(BigDecimal r0120_weighted_interest_resi) {
		this.r0120_weighted_interest_resi = r0120_weighted_interest_resi;
	}
	public BigDecimal getR0120_total_loan_outstanding_resi() {
		return r0120_total_loan_outstanding_resi;
	}
	public void setR0120_total_loan_outstanding_resi(BigDecimal r0120_total_loan_outstanding_resi) {
		this.r0120_total_loan_outstanding_resi = r0120_total_loan_outstanding_resi;
	}
	public BigDecimal getR0120_total_interest_income_resi() {
		return r0120_total_interest_income_resi;
	}
	public void setR0120_total_interest_income_resi(BigDecimal r0120_total_interest_income_resi) {
		this.r0120_total_interest_income_resi = r0120_total_interest_income_resi;
	}
	public BigDecimal getR0120_new_loan_in_month_nonresi() {
		return r0120_new_loan_in_month_nonresi;
	}
	public void setR0120_new_loan_in_month_nonresi(BigDecimal r0120_new_loan_in_month_nonresi) {
		this.r0120_new_loan_in_month_nonresi = r0120_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0120_min_interest_rate_nonresi() {
		return r0120_min_interest_rate_nonresi;
	}
	public void setR0120_min_interest_rate_nonresi(BigDecimal r0120_min_interest_rate_nonresi) {
		this.r0120_min_interest_rate_nonresi = r0120_min_interest_rate_nonresi;
	}
	public BigDecimal getR0120_max_interest_rate_nonresi() {
		return r0120_max_interest_rate_nonresi;
	}
	public void setR0120_max_interest_rate_nonresi(BigDecimal r0120_max_interest_rate_nonresi) {
		this.r0120_max_interest_rate_nonresi = r0120_max_interest_rate_nonresi;
	}
	public BigDecimal getR0120_weighted_interest_nonresi() {
		return r0120_weighted_interest_nonresi;
	}
	public void setR0120_weighted_interest_nonresi(BigDecimal r0120_weighted_interest_nonresi) {
		this.r0120_weighted_interest_nonresi = r0120_weighted_interest_nonresi;
	}
	public BigDecimal getR0120_total_loan_outstanding_nonresi() {
		return r0120_total_loan_outstanding_nonresi;
	}
	public void setR0120_total_loan_outstanding_nonresi(BigDecimal r0120_total_loan_outstanding_nonresi) {
		this.r0120_total_loan_outstanding_nonresi = r0120_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0120_total_interest_income_nonresi() {
		return r0120_total_interest_income_nonresi;
	}
	public void setR0120_total_interest_income_nonresi(BigDecimal r0120_total_interest_income_nonresi) {
		this.r0120_total_interest_income_nonresi = r0120_total_interest_income_nonresi;
	}
	public String getR0130_loantype() {
		return r0130_loantype;
	}
	public void setR0130_loantype(String r0130_loantype) {
		this.r0130_loantype = r0130_loantype;
	}
	public BigDecimal getR0130_new_loan_in_month_resi() {
		return r0130_new_loan_in_month_resi;
	}
	public void setR0130_new_loan_in_month_resi(BigDecimal r0130_new_loan_in_month_resi) {
		this.r0130_new_loan_in_month_resi = r0130_new_loan_in_month_resi;
	}
	public BigDecimal getR0130_min_interest_rate_resi() {
		return r0130_min_interest_rate_resi;
	}
	public void setR0130_min_interest_rate_resi(BigDecimal r0130_min_interest_rate_resi) {
		this.r0130_min_interest_rate_resi = r0130_min_interest_rate_resi;
	}
	public BigDecimal getR0130_max_interest_rate_resi() {
		return r0130_max_interest_rate_resi;
	}
	public void setR0130_max_interest_rate_resi(BigDecimal r0130_max_interest_rate_resi) {
		this.r0130_max_interest_rate_resi = r0130_max_interest_rate_resi;
	}
	public BigDecimal getR0130_weighted_interest_resi() {
		return r0130_weighted_interest_resi;
	}
	public void setR0130_weighted_interest_resi(BigDecimal r0130_weighted_interest_resi) {
		this.r0130_weighted_interest_resi = r0130_weighted_interest_resi;
	}
	public BigDecimal getR0130_total_loan_outstanding_resi() {
		return r0130_total_loan_outstanding_resi;
	}
	public void setR0130_total_loan_outstanding_resi(BigDecimal r0130_total_loan_outstanding_resi) {
		this.r0130_total_loan_outstanding_resi = r0130_total_loan_outstanding_resi;
	}
	public BigDecimal getR0130_total_interest_income_resi() {
		return r0130_total_interest_income_resi;
	}
	public void setR0130_total_interest_income_resi(BigDecimal r0130_total_interest_income_resi) {
		this.r0130_total_interest_income_resi = r0130_total_interest_income_resi;
	}
	public BigDecimal getR0130_new_loan_in_month_nonresi() {
		return r0130_new_loan_in_month_nonresi;
	}
	public void setR0130_new_loan_in_month_nonresi(BigDecimal r0130_new_loan_in_month_nonresi) {
		this.r0130_new_loan_in_month_nonresi = r0130_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0130_min_interest_rate_nonresi() {
		return r0130_min_interest_rate_nonresi;
	}
	public void setR0130_min_interest_rate_nonresi(BigDecimal r0130_min_interest_rate_nonresi) {
		this.r0130_min_interest_rate_nonresi = r0130_min_interest_rate_nonresi;
	}
	public BigDecimal getR0130_max_interest_rate_nonresi() {
		return r0130_max_interest_rate_nonresi;
	}
	public void setR0130_max_interest_rate_nonresi(BigDecimal r0130_max_interest_rate_nonresi) {
		this.r0130_max_interest_rate_nonresi = r0130_max_interest_rate_nonresi;
	}
	public BigDecimal getR0130_weighted_interest_nonresi() {
		return r0130_weighted_interest_nonresi;
	}
	public void setR0130_weighted_interest_nonresi(BigDecimal r0130_weighted_interest_nonresi) {
		this.r0130_weighted_interest_nonresi = r0130_weighted_interest_nonresi;
	}
	public BigDecimal getR0130_total_loan_outstanding_nonresi() {
		return r0130_total_loan_outstanding_nonresi;
	}
	public void setR0130_total_loan_outstanding_nonresi(BigDecimal r0130_total_loan_outstanding_nonresi) {
		this.r0130_total_loan_outstanding_nonresi = r0130_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0130_total_interest_income_nonresi() {
		return r0130_total_interest_income_nonresi;
	}
	public void setR0130_total_interest_income_nonresi(BigDecimal r0130_total_interest_income_nonresi) {
		this.r0130_total_interest_income_nonresi = r0130_total_interest_income_nonresi;
	}
	public String getR0140_loantype() {
		return r0140_loantype;
	}
	public void setR0140_loantype(String r0140_loantype) {
		this.r0140_loantype = r0140_loantype;
	}
	public String getR0150_loantype() {
		return r0150_loantype;
	}
	public void setR0150_loantype(String r0150_loantype) {
		this.r0150_loantype = r0150_loantype;
	}
	public BigDecimal getR0150_new_loan_in_month_resi() {
		return r0150_new_loan_in_month_resi;
	}
	public void setR0150_new_loan_in_month_resi(BigDecimal r0150_new_loan_in_month_resi) {
		this.r0150_new_loan_in_month_resi = r0150_new_loan_in_month_resi;
	}
	public BigDecimal getR0150_min_interest_rate_resi() {
		return r0150_min_interest_rate_resi;
	}
	public void setR0150_min_interest_rate_resi(BigDecimal r0150_min_interest_rate_resi) {
		this.r0150_min_interest_rate_resi = r0150_min_interest_rate_resi;
	}
	public BigDecimal getR0150_max_interest_rate_resi() {
		return r0150_max_interest_rate_resi;
	}
	public void setR0150_max_interest_rate_resi(BigDecimal r0150_max_interest_rate_resi) {
		this.r0150_max_interest_rate_resi = r0150_max_interest_rate_resi;
	}
	public BigDecimal getR0150_weighted_interest_resi() {
		return r0150_weighted_interest_resi;
	}
	public void setR0150_weighted_interest_resi(BigDecimal r0150_weighted_interest_resi) {
		this.r0150_weighted_interest_resi = r0150_weighted_interest_resi;
	}
	public BigDecimal getR0150_total_loan_outstanding_resi() {
		return r0150_total_loan_outstanding_resi;
	}
	public void setR0150_total_loan_outstanding_resi(BigDecimal r0150_total_loan_outstanding_resi) {
		this.r0150_total_loan_outstanding_resi = r0150_total_loan_outstanding_resi;
	}
	public BigDecimal getR0150_total_interest_income_resi() {
		return r0150_total_interest_income_resi;
	}
	public void setR0150_total_interest_income_resi(BigDecimal r0150_total_interest_income_resi) {
		this.r0150_total_interest_income_resi = r0150_total_interest_income_resi;
	}
	public BigDecimal getR0150_new_loan_in_month_nonresi() {
		return r0150_new_loan_in_month_nonresi;
	}
	public void setR0150_new_loan_in_month_nonresi(BigDecimal r0150_new_loan_in_month_nonresi) {
		this.r0150_new_loan_in_month_nonresi = r0150_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0150_min_interest_rate_nonresi() {
		return r0150_min_interest_rate_nonresi;
	}
	public void setR0150_min_interest_rate_nonresi(BigDecimal r0150_min_interest_rate_nonresi) {
		this.r0150_min_interest_rate_nonresi = r0150_min_interest_rate_nonresi;
	}
	public BigDecimal getR0150_max_interest_rate_nonresi() {
		return r0150_max_interest_rate_nonresi;
	}
	public void setR0150_max_interest_rate_nonresi(BigDecimal r0150_max_interest_rate_nonresi) {
		this.r0150_max_interest_rate_nonresi = r0150_max_interest_rate_nonresi;
	}
	public BigDecimal getR0150_weighted_interest_nonresi() {
		return r0150_weighted_interest_nonresi;
	}
	public void setR0150_weighted_interest_nonresi(BigDecimal r0150_weighted_interest_nonresi) {
		this.r0150_weighted_interest_nonresi = r0150_weighted_interest_nonresi;
	}
	public BigDecimal getR0150_total_loan_outstanding_nonresi() {
		return r0150_total_loan_outstanding_nonresi;
	}
	public void setR0150_total_loan_outstanding_nonresi(BigDecimal r0150_total_loan_outstanding_nonresi) {
		this.r0150_total_loan_outstanding_nonresi = r0150_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0150_total_interest_income_nonresi() {
		return r0150_total_interest_income_nonresi;
	}
	public void setR0150_total_interest_income_nonresi(BigDecimal r0150_total_interest_income_nonresi) {
		this.r0150_total_interest_income_nonresi = r0150_total_interest_income_nonresi;
	}
	public String getR0160_loantype() {
		return r0160_loantype;
	}
	public void setR0160_loantype(String r0160_loantype) {
		this.r0160_loantype = r0160_loantype;
	}
	public BigDecimal getR0160_new_loan_in_month_resi() {
		return r0160_new_loan_in_month_resi;
	}
	public void setR0160_new_loan_in_month_resi(BigDecimal r0160_new_loan_in_month_resi) {
		this.r0160_new_loan_in_month_resi = r0160_new_loan_in_month_resi;
	}
	public BigDecimal getR0160_min_interest_rate_resi() {
		return r0160_min_interest_rate_resi;
	}
	public void setR0160_min_interest_rate_resi(BigDecimal r0160_min_interest_rate_resi) {
		this.r0160_min_interest_rate_resi = r0160_min_interest_rate_resi;
	}
	public BigDecimal getR0160_max_interest_rate_resi() {
		return r0160_max_interest_rate_resi;
	}
	public void setR0160_max_interest_rate_resi(BigDecimal r0160_max_interest_rate_resi) {
		this.r0160_max_interest_rate_resi = r0160_max_interest_rate_resi;
	}
	public BigDecimal getR0160_weighted_interest_resi() {
		return r0160_weighted_interest_resi;
	}
	public void setR0160_weighted_interest_resi(BigDecimal r0160_weighted_interest_resi) {
		this.r0160_weighted_interest_resi = r0160_weighted_interest_resi;
	}
	public BigDecimal getR0160_total_loan_outstanding_resi() {
		return r0160_total_loan_outstanding_resi;
	}
	public void setR0160_total_loan_outstanding_resi(BigDecimal r0160_total_loan_outstanding_resi) {
		this.r0160_total_loan_outstanding_resi = r0160_total_loan_outstanding_resi;
	}
	public BigDecimal getR0160_total_interest_income_resi() {
		return r0160_total_interest_income_resi;
	}
	public void setR0160_total_interest_income_resi(BigDecimal r0160_total_interest_income_resi) {
		this.r0160_total_interest_income_resi = r0160_total_interest_income_resi;
	}
	public BigDecimal getR0160_new_loan_in_month_nonresi() {
		return r0160_new_loan_in_month_nonresi;
	}
	public void setR0160_new_loan_in_month_nonresi(BigDecimal r0160_new_loan_in_month_nonresi) {
		this.r0160_new_loan_in_month_nonresi = r0160_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0160_min_interest_rate_nonresi() {
		return r0160_min_interest_rate_nonresi;
	}
	public void setR0160_min_interest_rate_nonresi(BigDecimal r0160_min_interest_rate_nonresi) {
		this.r0160_min_interest_rate_nonresi = r0160_min_interest_rate_nonresi;
	}
	public BigDecimal getR0160_max_interest_rate_nonresi() {
		return r0160_max_interest_rate_nonresi;
	}
	public void setR0160_max_interest_rate_nonresi(BigDecimal r0160_max_interest_rate_nonresi) {
		this.r0160_max_interest_rate_nonresi = r0160_max_interest_rate_nonresi;
	}
	public BigDecimal getR0160_weighted_interest_nonresi() {
		return r0160_weighted_interest_nonresi;
	}
	public void setR0160_weighted_interest_nonresi(BigDecimal r0160_weighted_interest_nonresi) {
		this.r0160_weighted_interest_nonresi = r0160_weighted_interest_nonresi;
	}
	public BigDecimal getR0160_total_loan_outstanding_nonresi() {
		return r0160_total_loan_outstanding_nonresi;
	}
	public void setR0160_total_loan_outstanding_nonresi(BigDecimal r0160_total_loan_outstanding_nonresi) {
		this.r0160_total_loan_outstanding_nonresi = r0160_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0160_total_interest_income_nonresi() {
		return r0160_total_interest_income_nonresi;
	}
	public void setR0160_total_interest_income_nonresi(BigDecimal r0160_total_interest_income_nonresi) {
		this.r0160_total_interest_income_nonresi = r0160_total_interest_income_nonresi;
	}
	public String getR0170_loantype() {
		return r0170_loantype;
	}
	public void setR0170_loantype(String r0170_loantype) {
		this.r0170_loantype = r0170_loantype;
	}
	public BigDecimal getR0170_new_loan_in_month_resi() {
		return r0170_new_loan_in_month_resi;
	}
	public void setR0170_new_loan_in_month_resi(BigDecimal r0170_new_loan_in_month_resi) {
		this.r0170_new_loan_in_month_resi = r0170_new_loan_in_month_resi;
	}
	public BigDecimal getR0170_min_interest_rate_resi() {
		return r0170_min_interest_rate_resi;
	}
	public void setR0170_min_interest_rate_resi(BigDecimal r0170_min_interest_rate_resi) {
		this.r0170_min_interest_rate_resi = r0170_min_interest_rate_resi;
	}
	public BigDecimal getR0170_max_interest_rate_resi() {
		return r0170_max_interest_rate_resi;
	}
	public void setR0170_max_interest_rate_resi(BigDecimal r0170_max_interest_rate_resi) {
		this.r0170_max_interest_rate_resi = r0170_max_interest_rate_resi;
	}
	public BigDecimal getR0170_weighted_interest_resi() {
		return r0170_weighted_interest_resi;
	}
	public void setR0170_weighted_interest_resi(BigDecimal r0170_weighted_interest_resi) {
		this.r0170_weighted_interest_resi = r0170_weighted_interest_resi;
	}
	public BigDecimal getR0170_total_loan_outstanding_resi() {
		return r0170_total_loan_outstanding_resi;
	}
	public void setR0170_total_loan_outstanding_resi(BigDecimal r0170_total_loan_outstanding_resi) {
		this.r0170_total_loan_outstanding_resi = r0170_total_loan_outstanding_resi;
	}
	public BigDecimal getR0170_total_interest_income_resi() {
		return r0170_total_interest_income_resi;
	}
	public void setR0170_total_interest_income_resi(BigDecimal r0170_total_interest_income_resi) {
		this.r0170_total_interest_income_resi = r0170_total_interest_income_resi;
	}
	public BigDecimal getR0170_new_loan_in_month_nonresi() {
		return r0170_new_loan_in_month_nonresi;
	}
	public void setR0170_new_loan_in_month_nonresi(BigDecimal r0170_new_loan_in_month_nonresi) {
		this.r0170_new_loan_in_month_nonresi = r0170_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0170_min_interest_rate_nonresi() {
		return r0170_min_interest_rate_nonresi;
	}
	public void setR0170_min_interest_rate_nonresi(BigDecimal r0170_min_interest_rate_nonresi) {
		this.r0170_min_interest_rate_nonresi = r0170_min_interest_rate_nonresi;
	}
	public BigDecimal getR0170_max_interest_rate_nonresi() {
		return r0170_max_interest_rate_nonresi;
	}
	public void setR0170_max_interest_rate_nonresi(BigDecimal r0170_max_interest_rate_nonresi) {
		this.r0170_max_interest_rate_nonresi = r0170_max_interest_rate_nonresi;
	}
	public BigDecimal getR0170_weighted_interest_nonresi() {
		return r0170_weighted_interest_nonresi;
	}
	public void setR0170_weighted_interest_nonresi(BigDecimal r0170_weighted_interest_nonresi) {
		this.r0170_weighted_interest_nonresi = r0170_weighted_interest_nonresi;
	}
	public BigDecimal getR0170_total_loan_outstanding_nonresi() {
		return r0170_total_loan_outstanding_nonresi;
	}
	public void setR0170_total_loan_outstanding_nonresi(BigDecimal r0170_total_loan_outstanding_nonresi) {
		this.r0170_total_loan_outstanding_nonresi = r0170_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0170_total_interest_income_nonresi() {
		return r0170_total_interest_income_nonresi;
	}
	public void setR0170_total_interest_income_nonresi(BigDecimal r0170_total_interest_income_nonresi) {
		this.r0170_total_interest_income_nonresi = r0170_total_interest_income_nonresi;
	}
	public String getR0180_loantype() {
		return r0180_loantype;
	}
	public void setR0180_loantype(String r0180_loantype) {
		this.r0180_loantype = r0180_loantype;
	}
	public String getR0190_loantype() {
		return r0190_loantype;
	}
	public void setR0190_loantype(String r0190_loantype) {
		this.r0190_loantype = r0190_loantype;
	}
	public BigDecimal getR0190_new_loan_in_month_resi() {
		return r0190_new_loan_in_month_resi;
	}
	public void setR0190_new_loan_in_month_resi(BigDecimal r0190_new_loan_in_month_resi) {
		this.r0190_new_loan_in_month_resi = r0190_new_loan_in_month_resi;
	}
	public BigDecimal getR0190_min_interest_rate_resi() {
		return r0190_min_interest_rate_resi;
	}
	public void setR0190_min_interest_rate_resi(BigDecimal r0190_min_interest_rate_resi) {
		this.r0190_min_interest_rate_resi = r0190_min_interest_rate_resi;
	}
	public BigDecimal getR0190_max_interest_rate_resi() {
		return r0190_max_interest_rate_resi;
	}
	public void setR0190_max_interest_rate_resi(BigDecimal r0190_max_interest_rate_resi) {
		this.r0190_max_interest_rate_resi = r0190_max_interest_rate_resi;
	}
	public BigDecimal getR0190_weighted_interest_resi() {
		return r0190_weighted_interest_resi;
	}
	public void setR0190_weighted_interest_resi(BigDecimal r0190_weighted_interest_resi) {
		this.r0190_weighted_interest_resi = r0190_weighted_interest_resi;
	}
	public BigDecimal getR0190_total_loan_outstanding_resi() {
		return r0190_total_loan_outstanding_resi;
	}
	public void setR0190_total_loan_outstanding_resi(BigDecimal r0190_total_loan_outstanding_resi) {
		this.r0190_total_loan_outstanding_resi = r0190_total_loan_outstanding_resi;
	}
	public BigDecimal getR0190_total_interest_income_resi() {
		return r0190_total_interest_income_resi;
	}
	public void setR0190_total_interest_income_resi(BigDecimal r0190_total_interest_income_resi) {
		this.r0190_total_interest_income_resi = r0190_total_interest_income_resi;
	}
	public BigDecimal getR0190_new_loan_in_month_nonresi() {
		return r0190_new_loan_in_month_nonresi;
	}
	public void setR0190_new_loan_in_month_nonresi(BigDecimal r0190_new_loan_in_month_nonresi) {
		this.r0190_new_loan_in_month_nonresi = r0190_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0190_min_interest_rate_nonresi() {
		return r0190_min_interest_rate_nonresi;
	}
	public void setR0190_min_interest_rate_nonresi(BigDecimal r0190_min_interest_rate_nonresi) {
		this.r0190_min_interest_rate_nonresi = r0190_min_interest_rate_nonresi;
	}
	public BigDecimal getR0190_max_interest_rate_nonresi() {
		return r0190_max_interest_rate_nonresi;
	}
	public void setR0190_max_interest_rate_nonresi(BigDecimal r0190_max_interest_rate_nonresi) {
		this.r0190_max_interest_rate_nonresi = r0190_max_interest_rate_nonresi;
	}
	public BigDecimal getR0190_weighted_interest_nonresi() {
		return r0190_weighted_interest_nonresi;
	}
	public void setR0190_weighted_interest_nonresi(BigDecimal r0190_weighted_interest_nonresi) {
		this.r0190_weighted_interest_nonresi = r0190_weighted_interest_nonresi;
	}
	public BigDecimal getR0190_total_loan_outstanding_nonresi() {
		return r0190_total_loan_outstanding_nonresi;
	}
	public void setR0190_total_loan_outstanding_nonresi(BigDecimal r0190_total_loan_outstanding_nonresi) {
		this.r0190_total_loan_outstanding_nonresi = r0190_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0190_total_interest_income_nonresi() {
		return r0190_total_interest_income_nonresi;
	}
	public void setR0190_total_interest_income_nonresi(BigDecimal r0190_total_interest_income_nonresi) {
		this.r0190_total_interest_income_nonresi = r0190_total_interest_income_nonresi;
	}
	public String getR0200_loantype() {
		return r0200_loantype;
	}
	public void setR0200_loantype(String r0200_loantype) {
		this.r0200_loantype = r0200_loantype;
	}
	public BigDecimal getR0200_new_loan_in_month_resi() {
		return r0200_new_loan_in_month_resi;
	}
	public void setR0200_new_loan_in_month_resi(BigDecimal r0200_new_loan_in_month_resi) {
		this.r0200_new_loan_in_month_resi = r0200_new_loan_in_month_resi;
	}
	public BigDecimal getR0200_min_interest_rate_resi() {
		return r0200_min_interest_rate_resi;
	}
	public void setR0200_min_interest_rate_resi(BigDecimal r0200_min_interest_rate_resi) {
		this.r0200_min_interest_rate_resi = r0200_min_interest_rate_resi;
	}
	public BigDecimal getR0200_max_interest_rate_resi() {
		return r0200_max_interest_rate_resi;
	}
	public void setR0200_max_interest_rate_resi(BigDecimal r0200_max_interest_rate_resi) {
		this.r0200_max_interest_rate_resi = r0200_max_interest_rate_resi;
	}
	public BigDecimal getR0200_weighted_interest_resi() {
		return r0200_weighted_interest_resi;
	}
	public void setR0200_weighted_interest_resi(BigDecimal r0200_weighted_interest_resi) {
		this.r0200_weighted_interest_resi = r0200_weighted_interest_resi;
	}
	public BigDecimal getR0200_total_loan_outstanding_resi() {
		return r0200_total_loan_outstanding_resi;
	}
	public void setR0200_total_loan_outstanding_resi(BigDecimal r0200_total_loan_outstanding_resi) {
		this.r0200_total_loan_outstanding_resi = r0200_total_loan_outstanding_resi;
	}
	public BigDecimal getR0200_total_interest_income_resi() {
		return r0200_total_interest_income_resi;
	}
	public void setR0200_total_interest_income_resi(BigDecimal r0200_total_interest_income_resi) {
		this.r0200_total_interest_income_resi = r0200_total_interest_income_resi;
	}
	public BigDecimal getR0200_new_loan_in_month_nonresi() {
		return r0200_new_loan_in_month_nonresi;
	}
	public void setR0200_new_loan_in_month_nonresi(BigDecimal r0200_new_loan_in_month_nonresi) {
		this.r0200_new_loan_in_month_nonresi = r0200_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0200_min_interest_rate_nonresi() {
		return r0200_min_interest_rate_nonresi;
	}
	public void setR0200_min_interest_rate_nonresi(BigDecimal r0200_min_interest_rate_nonresi) {
		this.r0200_min_interest_rate_nonresi = r0200_min_interest_rate_nonresi;
	}
	public BigDecimal getR0200_max_interest_rate_nonresi() {
		return r0200_max_interest_rate_nonresi;
	}
	public void setR0200_max_interest_rate_nonresi(BigDecimal r0200_max_interest_rate_nonresi) {
		this.r0200_max_interest_rate_nonresi = r0200_max_interest_rate_nonresi;
	}
	public BigDecimal getR0200_weighted_interest_nonresi() {
		return r0200_weighted_interest_nonresi;
	}
	public void setR0200_weighted_interest_nonresi(BigDecimal r0200_weighted_interest_nonresi) {
		this.r0200_weighted_interest_nonresi = r0200_weighted_interest_nonresi;
	}
	public BigDecimal getR0200_total_loan_outstanding_nonresi() {
		return r0200_total_loan_outstanding_nonresi;
	}
	public void setR0200_total_loan_outstanding_nonresi(BigDecimal r0200_total_loan_outstanding_nonresi) {
		this.r0200_total_loan_outstanding_nonresi = r0200_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0200_total_interest_income_nonresi() {
		return r0200_total_interest_income_nonresi;
	}
	public void setR0200_total_interest_income_nonresi(BigDecimal r0200_total_interest_income_nonresi) {
		this.r0200_total_interest_income_nonresi = r0200_total_interest_income_nonresi;
	}
	public String getR0210_loantype() {
		return r0210_loantype;
	}
	public void setR0210_loantype(String r0210_loantype) {
		this.r0210_loantype = r0210_loantype;
	}
	public BigDecimal getR0210_new_loan_in_month_resi() {
		return r0210_new_loan_in_month_resi;
	}
	public void setR0210_new_loan_in_month_resi(BigDecimal r0210_new_loan_in_month_resi) {
		this.r0210_new_loan_in_month_resi = r0210_new_loan_in_month_resi;
	}
	public BigDecimal getR0210_min_interest_rate_resi() {
		return r0210_min_interest_rate_resi;
	}
	public void setR0210_min_interest_rate_resi(BigDecimal r0210_min_interest_rate_resi) {
		this.r0210_min_interest_rate_resi = r0210_min_interest_rate_resi;
	}
	public BigDecimal getR0210_max_interest_rate_resi() {
		return r0210_max_interest_rate_resi;
	}
	public void setR0210_max_interest_rate_resi(BigDecimal r0210_max_interest_rate_resi) {
		this.r0210_max_interest_rate_resi = r0210_max_interest_rate_resi;
	}
	public BigDecimal getR0210_weighted_interest_resi() {
		return r0210_weighted_interest_resi;
	}
	public void setR0210_weighted_interest_resi(BigDecimal r0210_weighted_interest_resi) {
		this.r0210_weighted_interest_resi = r0210_weighted_interest_resi;
	}
	public BigDecimal getR0210_total_loan_outstanding_resi() {
		return r0210_total_loan_outstanding_resi;
	}
	public void setR0210_total_loan_outstanding_resi(BigDecimal r0210_total_loan_outstanding_resi) {
		this.r0210_total_loan_outstanding_resi = r0210_total_loan_outstanding_resi;
	}
	public BigDecimal getR0210_total_interest_income_resi() {
		return r0210_total_interest_income_resi;
	}
	public void setR0210_total_interest_income_resi(BigDecimal r0210_total_interest_income_resi) {
		this.r0210_total_interest_income_resi = r0210_total_interest_income_resi;
	}
	public BigDecimal getR0210_new_loan_in_month_nonresi() {
		return r0210_new_loan_in_month_nonresi;
	}
	public void setR0210_new_loan_in_month_nonresi(BigDecimal r0210_new_loan_in_month_nonresi) {
		this.r0210_new_loan_in_month_nonresi = r0210_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0210_min_interest_rate_nonresi() {
		return r0210_min_interest_rate_nonresi;
	}
	public void setR0210_min_interest_rate_nonresi(BigDecimal r0210_min_interest_rate_nonresi) {
		this.r0210_min_interest_rate_nonresi = r0210_min_interest_rate_nonresi;
	}
	public BigDecimal getR0210_max_interest_rate_nonresi() {
		return r0210_max_interest_rate_nonresi;
	}
	public void setR0210_max_interest_rate_nonresi(BigDecimal r0210_max_interest_rate_nonresi) {
		this.r0210_max_interest_rate_nonresi = r0210_max_interest_rate_nonresi;
	}
	public BigDecimal getR0210_weighted_interest_nonresi() {
		return r0210_weighted_interest_nonresi;
	}
	public void setR0210_weighted_interest_nonresi(BigDecimal r0210_weighted_interest_nonresi) {
		this.r0210_weighted_interest_nonresi = r0210_weighted_interest_nonresi;
	}
	public BigDecimal getR0210_total_loan_outstanding_nonresi() {
		return r0210_total_loan_outstanding_nonresi;
	}
	public void setR0210_total_loan_outstanding_nonresi(BigDecimal r0210_total_loan_outstanding_nonresi) {
		this.r0210_total_loan_outstanding_nonresi = r0210_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0210_total_interest_income_nonresi() {
		return r0210_total_interest_income_nonresi;
	}
	public void setR0210_total_interest_income_nonresi(BigDecimal r0210_total_interest_income_nonresi) {
		this.r0210_total_interest_income_nonresi = r0210_total_interest_income_nonresi;
	}
	public String getR0220_loantype() {
		return r0220_loantype;
	}
	public void setR0220_loantype(String r0220_loantype) {
		this.r0220_loantype = r0220_loantype;
	}
	public String getR0230_loantype() {
		return r0230_loantype;
	}
	public void setR0230_loantype(String r0230_loantype) {
		this.r0230_loantype = r0230_loantype;
	}
	public BigDecimal getR0230_new_loan_in_month_resi() {
		return r0230_new_loan_in_month_resi;
	}
	public void setR0230_new_loan_in_month_resi(BigDecimal r0230_new_loan_in_month_resi) {
		this.r0230_new_loan_in_month_resi = r0230_new_loan_in_month_resi;
	}
	public BigDecimal getR0230_min_interest_rate_resi() {
		return r0230_min_interest_rate_resi;
	}
	public void setR0230_min_interest_rate_resi(BigDecimal r0230_min_interest_rate_resi) {
		this.r0230_min_interest_rate_resi = r0230_min_interest_rate_resi;
	}
	public BigDecimal getR0230_max_interest_rate_resi() {
		return r0230_max_interest_rate_resi;
	}
	public void setR0230_max_interest_rate_resi(BigDecimal r0230_max_interest_rate_resi) {
		this.r0230_max_interest_rate_resi = r0230_max_interest_rate_resi;
	}
	public BigDecimal getR0230_weighted_interest_resi() {
		return r0230_weighted_interest_resi;
	}
	public void setR0230_weighted_interest_resi(BigDecimal r0230_weighted_interest_resi) {
		this.r0230_weighted_interest_resi = r0230_weighted_interest_resi;
	}
	public BigDecimal getR0230_total_loan_outstanding_resi() {
		return r0230_total_loan_outstanding_resi;
	}
	public void setR0230_total_loan_outstanding_resi(BigDecimal r0230_total_loan_outstanding_resi) {
		this.r0230_total_loan_outstanding_resi = r0230_total_loan_outstanding_resi;
	}
	public BigDecimal getR0230_total_interest_income_resi() {
		return r0230_total_interest_income_resi;
	}
	public void setR0230_total_interest_income_resi(BigDecimal r0230_total_interest_income_resi) {
		this.r0230_total_interest_income_resi = r0230_total_interest_income_resi;
	}
	public BigDecimal getR0230_new_loan_in_month_nonresi() {
		return r0230_new_loan_in_month_nonresi;
	}
	public void setR0230_new_loan_in_month_nonresi(BigDecimal r0230_new_loan_in_month_nonresi) {
		this.r0230_new_loan_in_month_nonresi = r0230_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0230_min_interest_rate_nonresi() {
		return r0230_min_interest_rate_nonresi;
	}
	public void setR0230_min_interest_rate_nonresi(BigDecimal r0230_min_interest_rate_nonresi) {
		this.r0230_min_interest_rate_nonresi = r0230_min_interest_rate_nonresi;
	}
	public BigDecimal getR0230_max_interest_rate_nonresi() {
		return r0230_max_interest_rate_nonresi;
	}
	public void setR0230_max_interest_rate_nonresi(BigDecimal r0230_max_interest_rate_nonresi) {
		this.r0230_max_interest_rate_nonresi = r0230_max_interest_rate_nonresi;
	}
	public BigDecimal getR0230_weighted_interest_nonresi() {
		return r0230_weighted_interest_nonresi;
	}
	public void setR0230_weighted_interest_nonresi(BigDecimal r0230_weighted_interest_nonresi) {
		this.r0230_weighted_interest_nonresi = r0230_weighted_interest_nonresi;
	}
	public BigDecimal getR0230_total_loan_outstanding_nonresi() {
		return r0230_total_loan_outstanding_nonresi;
	}
	public void setR0230_total_loan_outstanding_nonresi(BigDecimal r0230_total_loan_outstanding_nonresi) {
		this.r0230_total_loan_outstanding_nonresi = r0230_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0230_total_interest_income_nonresi() {
		return r0230_total_interest_income_nonresi;
	}
	public void setR0230_total_interest_income_nonresi(BigDecimal r0230_total_interest_income_nonresi) {
		this.r0230_total_interest_income_nonresi = r0230_total_interest_income_nonresi;
	}
	public String getR0240_loantype() {
		return r0240_loantype;
	}
	public void setR0240_loantype(String r0240_loantype) {
		this.r0240_loantype = r0240_loantype;
	}
	public BigDecimal getR0240_new_loan_in_month_resi() {
		return r0240_new_loan_in_month_resi;
	}
	public void setR0240_new_loan_in_month_resi(BigDecimal r0240_new_loan_in_month_resi) {
		this.r0240_new_loan_in_month_resi = r0240_new_loan_in_month_resi;
	}
	public BigDecimal getR0240_min_interest_rate_resi() {
		return r0240_min_interest_rate_resi;
	}
	public void setR0240_min_interest_rate_resi(BigDecimal r0240_min_interest_rate_resi) {
		this.r0240_min_interest_rate_resi = r0240_min_interest_rate_resi;
	}
	public BigDecimal getR0240_max_interest_rate_resi() {
		return r0240_max_interest_rate_resi;
	}
	public void setR0240_max_interest_rate_resi(BigDecimal r0240_max_interest_rate_resi) {
		this.r0240_max_interest_rate_resi = r0240_max_interest_rate_resi;
	}
	public BigDecimal getR0240_weighted_interest_resi() {
		return r0240_weighted_interest_resi;
	}
	public void setR0240_weighted_interest_resi(BigDecimal r0240_weighted_interest_resi) {
		this.r0240_weighted_interest_resi = r0240_weighted_interest_resi;
	}
	public BigDecimal getR0240_total_loan_outstanding_resi() {
		return r0240_total_loan_outstanding_resi;
	}
	public void setR0240_total_loan_outstanding_resi(BigDecimal r0240_total_loan_outstanding_resi) {
		this.r0240_total_loan_outstanding_resi = r0240_total_loan_outstanding_resi;
	}
	public BigDecimal getR0240_total_interest_income_resi() {
		return r0240_total_interest_income_resi;
	}
	public void setR0240_total_interest_income_resi(BigDecimal r0240_total_interest_income_resi) {
		this.r0240_total_interest_income_resi = r0240_total_interest_income_resi;
	}
	public BigDecimal getR0240_new_loan_in_month_nonresi() {
		return r0240_new_loan_in_month_nonresi;
	}
	public void setR0240_new_loan_in_month_nonresi(BigDecimal r0240_new_loan_in_month_nonresi) {
		this.r0240_new_loan_in_month_nonresi = r0240_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0240_min_interest_rate_nonresi() {
		return r0240_min_interest_rate_nonresi;
	}
	public void setR0240_min_interest_rate_nonresi(BigDecimal r0240_min_interest_rate_nonresi) {
		this.r0240_min_interest_rate_nonresi = r0240_min_interest_rate_nonresi;
	}
	public BigDecimal getR0240_max_interest_rate_nonresi() {
		return r0240_max_interest_rate_nonresi;
	}
	public void setR0240_max_interest_rate_nonresi(BigDecimal r0240_max_interest_rate_nonresi) {
		this.r0240_max_interest_rate_nonresi = r0240_max_interest_rate_nonresi;
	}
	public BigDecimal getR0240_weighted_interest_nonresi() {
		return r0240_weighted_interest_nonresi;
	}
	public void setR0240_weighted_interest_nonresi(BigDecimal r0240_weighted_interest_nonresi) {
		this.r0240_weighted_interest_nonresi = r0240_weighted_interest_nonresi;
	}
	public BigDecimal getR0240_total_loan_outstanding_nonresi() {
		return r0240_total_loan_outstanding_nonresi;
	}
	public void setR0240_total_loan_outstanding_nonresi(BigDecimal r0240_total_loan_outstanding_nonresi) {
		this.r0240_total_loan_outstanding_nonresi = r0240_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0240_total_interest_income_nonresi() {
		return r0240_total_interest_income_nonresi;
	}
	public void setR0240_total_interest_income_nonresi(BigDecimal r0240_total_interest_income_nonresi) {
		this.r0240_total_interest_income_nonresi = r0240_total_interest_income_nonresi;
	}
	public String getR0250_loantype() {
		return r0250_loantype;
	}
	public void setR0250_loantype(String r0250_loantype) {
		this.r0250_loantype = r0250_loantype;
	}
	public BigDecimal getR0250_new_loan_in_month_resi() {
		return r0250_new_loan_in_month_resi;
	}
	public void setR0250_new_loan_in_month_resi(BigDecimal r0250_new_loan_in_month_resi) {
		this.r0250_new_loan_in_month_resi = r0250_new_loan_in_month_resi;
	}
	public BigDecimal getR0250_min_interest_rate_resi() {
		return r0250_min_interest_rate_resi;
	}
	public void setR0250_min_interest_rate_resi(BigDecimal r0250_min_interest_rate_resi) {
		this.r0250_min_interest_rate_resi = r0250_min_interest_rate_resi;
	}
	public BigDecimal getR0250_max_interest_rate_resi() {
		return r0250_max_interest_rate_resi;
	}
	public void setR0250_max_interest_rate_resi(BigDecimal r0250_max_interest_rate_resi) {
		this.r0250_max_interest_rate_resi = r0250_max_interest_rate_resi;
	}
	public BigDecimal getR0250_weighted_interest_resi() {
		return r0250_weighted_interest_resi;
	}
	public void setR0250_weighted_interest_resi(BigDecimal r0250_weighted_interest_resi) {
		this.r0250_weighted_interest_resi = r0250_weighted_interest_resi;
	}
	public BigDecimal getR0250_total_loan_outstanding_resi() {
		return r0250_total_loan_outstanding_resi;
	}
	public void setR0250_total_loan_outstanding_resi(BigDecimal r0250_total_loan_outstanding_resi) {
		this.r0250_total_loan_outstanding_resi = r0250_total_loan_outstanding_resi;
	}
	public BigDecimal getR0250_total_interest_income_resi() {
		return r0250_total_interest_income_resi;
	}
	public void setR0250_total_interest_income_resi(BigDecimal r0250_total_interest_income_resi) {
		this.r0250_total_interest_income_resi = r0250_total_interest_income_resi;
	}
	public BigDecimal getR0250_new_loan_in_month_nonresi() {
		return r0250_new_loan_in_month_nonresi;
	}
	public void setR0250_new_loan_in_month_nonresi(BigDecimal r0250_new_loan_in_month_nonresi) {
		this.r0250_new_loan_in_month_nonresi = r0250_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0250_min_interest_rate_nonresi() {
		return r0250_min_interest_rate_nonresi;
	}
	public void setR0250_min_interest_rate_nonresi(BigDecimal r0250_min_interest_rate_nonresi) {
		this.r0250_min_interest_rate_nonresi = r0250_min_interest_rate_nonresi;
	}
	public BigDecimal getR0250_max_interest_rate_nonresi() {
		return r0250_max_interest_rate_nonresi;
	}
	public void setR0250_max_interest_rate_nonresi(BigDecimal r0250_max_interest_rate_nonresi) {
		this.r0250_max_interest_rate_nonresi = r0250_max_interest_rate_nonresi;
	}
	public BigDecimal getR0250_weighted_interest_nonresi() {
		return r0250_weighted_interest_nonresi;
	}
	public void setR0250_weighted_interest_nonresi(BigDecimal r0250_weighted_interest_nonresi) {
		this.r0250_weighted_interest_nonresi = r0250_weighted_interest_nonresi;
	}
	public BigDecimal getR0250_total_loan_outstanding_nonresi() {
		return r0250_total_loan_outstanding_nonresi;
	}
	public void setR0250_total_loan_outstanding_nonresi(BigDecimal r0250_total_loan_outstanding_nonresi) {
		this.r0250_total_loan_outstanding_nonresi = r0250_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0250_total_interest_income_nonresi() {
		return r0250_total_interest_income_nonresi;
	}
	public void setR0250_total_interest_income_nonresi(BigDecimal r0250_total_interest_income_nonresi) {
		this.r0250_total_interest_income_nonresi = r0250_total_interest_income_nonresi;
	}
	public String getR0260_loantype() {
		return r0260_loantype;
	}
	public void setR0260_loantype(String r0260_loantype) {
		this.r0260_loantype = r0260_loantype;
	}
	public BigDecimal getR0260_new_loan_in_month_resi() {
		return r0260_new_loan_in_month_resi;
	}
	public void setR0260_new_loan_in_month_resi(BigDecimal r0260_new_loan_in_month_resi) {
		this.r0260_new_loan_in_month_resi = r0260_new_loan_in_month_resi;
	}
	public BigDecimal getR0260_min_interest_rate_resi() {
		return r0260_min_interest_rate_resi;
	}
	public void setR0260_min_interest_rate_resi(BigDecimal r0260_min_interest_rate_resi) {
		this.r0260_min_interest_rate_resi = r0260_min_interest_rate_resi;
	}
	public BigDecimal getR0260_max_interest_rate_resi() {
		return r0260_max_interest_rate_resi;
	}
	public void setR0260_max_interest_rate_resi(BigDecimal r0260_max_interest_rate_resi) {
		this.r0260_max_interest_rate_resi = r0260_max_interest_rate_resi;
	}
	public BigDecimal getR0260_weighted_interest_resi() {
		return r0260_weighted_interest_resi;
	}
	public void setR0260_weighted_interest_resi(BigDecimal r0260_weighted_interest_resi) {
		this.r0260_weighted_interest_resi = r0260_weighted_interest_resi;
	}
	public BigDecimal getR0260_total_loan_outstanding_resi() {
		return r0260_total_loan_outstanding_resi;
	}
	public void setR0260_total_loan_outstanding_resi(BigDecimal r0260_total_loan_outstanding_resi) {
		this.r0260_total_loan_outstanding_resi = r0260_total_loan_outstanding_resi;
	}
	public BigDecimal getR0260_total_interest_income_resi() {
		return r0260_total_interest_income_resi;
	}
	public void setR0260_total_interest_income_resi(BigDecimal r0260_total_interest_income_resi) {
		this.r0260_total_interest_income_resi = r0260_total_interest_income_resi;
	}
	public BigDecimal getR0260_new_loan_in_month_nonresi() {
		return r0260_new_loan_in_month_nonresi;
	}
	public void setR0260_new_loan_in_month_nonresi(BigDecimal r0260_new_loan_in_month_nonresi) {
		this.r0260_new_loan_in_month_nonresi = r0260_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0260_min_interest_rate_nonresi() {
		return r0260_min_interest_rate_nonresi;
	}
	public void setR0260_min_interest_rate_nonresi(BigDecimal r0260_min_interest_rate_nonresi) {
		this.r0260_min_interest_rate_nonresi = r0260_min_interest_rate_nonresi;
	}
	public BigDecimal getR0260_max_interest_rate_nonresi() {
		return r0260_max_interest_rate_nonresi;
	}
	public void setR0260_max_interest_rate_nonresi(BigDecimal r0260_max_interest_rate_nonresi) {
		this.r0260_max_interest_rate_nonresi = r0260_max_interest_rate_nonresi;
	}
	public BigDecimal getR0260_weighted_interest_nonresi() {
		return r0260_weighted_interest_nonresi;
	}
	public void setR0260_weighted_interest_nonresi(BigDecimal r0260_weighted_interest_nonresi) {
		this.r0260_weighted_interest_nonresi = r0260_weighted_interest_nonresi;
	}
	public BigDecimal getR0260_total_loan_outstanding_nonresi() {
		return r0260_total_loan_outstanding_nonresi;
	}
	public void setR0260_total_loan_outstanding_nonresi(BigDecimal r0260_total_loan_outstanding_nonresi) {
		this.r0260_total_loan_outstanding_nonresi = r0260_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0260_total_interest_income_nonresi() {
		return r0260_total_interest_income_nonresi;
	}
	public void setR0260_total_interest_income_nonresi(BigDecimal r0260_total_interest_income_nonresi) {
		this.r0260_total_interest_income_nonresi = r0260_total_interest_income_nonresi;
	}
	public String getR0270_loantype() {
		return r0270_loantype;
	}
	public void setR0270_loantype(String r0270_loantype) {
		this.r0270_loantype = r0270_loantype;
	}
	public BigDecimal getR0270_new_loan_in_month_resi() {
		return r0270_new_loan_in_month_resi;
	}
	public void setR0270_new_loan_in_month_resi(BigDecimal r0270_new_loan_in_month_resi) {
		this.r0270_new_loan_in_month_resi = r0270_new_loan_in_month_resi;
	}
	public BigDecimal getR0270_min_interest_rate_resi() {
		return r0270_min_interest_rate_resi;
	}
	public void setR0270_min_interest_rate_resi(BigDecimal r0270_min_interest_rate_resi) {
		this.r0270_min_interest_rate_resi = r0270_min_interest_rate_resi;
	}
	public BigDecimal getR0270_max_interest_rate_resi() {
		return r0270_max_interest_rate_resi;
	}
	public void setR0270_max_interest_rate_resi(BigDecimal r0270_max_interest_rate_resi) {
		this.r0270_max_interest_rate_resi = r0270_max_interest_rate_resi;
	}
	public BigDecimal getR0270_weighted_interest_resi() {
		return r0270_weighted_interest_resi;
	}
	public void setR0270_weighted_interest_resi(BigDecimal r0270_weighted_interest_resi) {
		this.r0270_weighted_interest_resi = r0270_weighted_interest_resi;
	}
	public BigDecimal getR0270_total_loan_outstanding_resi() {
		return r0270_total_loan_outstanding_resi;
	}
	public void setR0270_total_loan_outstanding_resi(BigDecimal r0270_total_loan_outstanding_resi) {
		this.r0270_total_loan_outstanding_resi = r0270_total_loan_outstanding_resi;
	}
	public BigDecimal getR0270_total_interest_income_resi() {
		return r0270_total_interest_income_resi;
	}
	public void setR0270_total_interest_income_resi(BigDecimal r0270_total_interest_income_resi) {
		this.r0270_total_interest_income_resi = r0270_total_interest_income_resi;
	}
	public BigDecimal getR0270_new_loan_in_month_nonresi() {
		return r0270_new_loan_in_month_nonresi;
	}
	public void setR0270_new_loan_in_month_nonresi(BigDecimal r0270_new_loan_in_month_nonresi) {
		this.r0270_new_loan_in_month_nonresi = r0270_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0270_min_interest_rate_nonresi() {
		return r0270_min_interest_rate_nonresi;
	}
	public void setR0270_min_interest_rate_nonresi(BigDecimal r0270_min_interest_rate_nonresi) {
		this.r0270_min_interest_rate_nonresi = r0270_min_interest_rate_nonresi;
	}
	public BigDecimal getR0270_max_interest_rate_nonresi() {
		return r0270_max_interest_rate_nonresi;
	}
	public void setR0270_max_interest_rate_nonresi(BigDecimal r0270_max_interest_rate_nonresi) {
		this.r0270_max_interest_rate_nonresi = r0270_max_interest_rate_nonresi;
	}
	public BigDecimal getR0270_weighted_interest_nonresi() {
		return r0270_weighted_interest_nonresi;
	}
	public void setR0270_weighted_interest_nonresi(BigDecimal r0270_weighted_interest_nonresi) {
		this.r0270_weighted_interest_nonresi = r0270_weighted_interest_nonresi;
	}
	public BigDecimal getR0270_total_loan_outstanding_nonresi() {
		return r0270_total_loan_outstanding_nonresi;
	}
	public void setR0270_total_loan_outstanding_nonresi(BigDecimal r0270_total_loan_outstanding_nonresi) {
		this.r0270_total_loan_outstanding_nonresi = r0270_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0270_total_interest_income_nonresi() {
		return r0270_total_interest_income_nonresi;
	}
	public void setR0270_total_interest_income_nonresi(BigDecimal r0270_total_interest_income_nonresi) {
		this.r0270_total_interest_income_nonresi = r0270_total_interest_income_nonresi;
	}
	public String getR0280_loantype() {
		return r0280_loantype;
	}
	public void setR0280_loantype(String r0280_loantype) {
		this.r0280_loantype = r0280_loantype;
	}
	public BigDecimal getR0280_new_loan_in_month_resi() {
		return r0280_new_loan_in_month_resi;
	}
	public void setR0280_new_loan_in_month_resi(BigDecimal r0280_new_loan_in_month_resi) {
		this.r0280_new_loan_in_month_resi = r0280_new_loan_in_month_resi;
	}
	public BigDecimal getR0280_min_interest_rate_resi() {
		return r0280_min_interest_rate_resi;
	}
	public void setR0280_min_interest_rate_resi(BigDecimal r0280_min_interest_rate_resi) {
		this.r0280_min_interest_rate_resi = r0280_min_interest_rate_resi;
	}
	public BigDecimal getR0280_max_interest_rate_resi() {
		return r0280_max_interest_rate_resi;
	}
	public void setR0280_max_interest_rate_resi(BigDecimal r0280_max_interest_rate_resi) {
		this.r0280_max_interest_rate_resi = r0280_max_interest_rate_resi;
	}
	public BigDecimal getR0280_weighted_interest_resi() {
		return r0280_weighted_interest_resi;
	}
	public void setR0280_weighted_interest_resi(BigDecimal r0280_weighted_interest_resi) {
		this.r0280_weighted_interest_resi = r0280_weighted_interest_resi;
	}
	public BigDecimal getR0280_total_loan_outstanding_resi() {
		return r0280_total_loan_outstanding_resi;
	}
	public void setR0280_total_loan_outstanding_resi(BigDecimal r0280_total_loan_outstanding_resi) {
		this.r0280_total_loan_outstanding_resi = r0280_total_loan_outstanding_resi;
	}
	public BigDecimal getR0280_total_interest_income_resi() {
		return r0280_total_interest_income_resi;
	}
	public void setR0280_total_interest_income_resi(BigDecimal r0280_total_interest_income_resi) {
		this.r0280_total_interest_income_resi = r0280_total_interest_income_resi;
	}
	public BigDecimal getR0280_new_loan_in_month_nonresi() {
		return r0280_new_loan_in_month_nonresi;
	}
	public void setR0280_new_loan_in_month_nonresi(BigDecimal r0280_new_loan_in_month_nonresi) {
		this.r0280_new_loan_in_month_nonresi = r0280_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0280_min_interest_rate_nonresi() {
		return r0280_min_interest_rate_nonresi;
	}
	public void setR0280_min_interest_rate_nonresi(BigDecimal r0280_min_interest_rate_nonresi) {
		this.r0280_min_interest_rate_nonresi = r0280_min_interest_rate_nonresi;
	}
	public BigDecimal getR0280_max_interest_rate_nonresi() {
		return r0280_max_interest_rate_nonresi;
	}
	public void setR0280_max_interest_rate_nonresi(BigDecimal r0280_max_interest_rate_nonresi) {
		this.r0280_max_interest_rate_nonresi = r0280_max_interest_rate_nonresi;
	}
	public BigDecimal getR0280_weighted_interest_nonresi() {
		return r0280_weighted_interest_nonresi;
	}
	public void setR0280_weighted_interest_nonresi(BigDecimal r0280_weighted_interest_nonresi) {
		this.r0280_weighted_interest_nonresi = r0280_weighted_interest_nonresi;
	}
	public BigDecimal getR0280_total_loan_outstanding_nonresi() {
		return r0280_total_loan_outstanding_nonresi;
	}
	public void setR0280_total_loan_outstanding_nonresi(BigDecimal r0280_total_loan_outstanding_nonresi) {
		this.r0280_total_loan_outstanding_nonresi = r0280_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0280_total_interest_income_nonresi() {
		return r0280_total_interest_income_nonresi;
	}
	public void setR0280_total_interest_income_nonresi(BigDecimal r0280_total_interest_income_nonresi) {
		this.r0280_total_interest_income_nonresi = r0280_total_interest_income_nonresi;
	}
	public String getR0290_loantype() {
		return r0290_loantype;
	}
	public void setR0290_loantype(String r0290_loantype) {
		this.r0290_loantype = r0290_loantype;
	}
	public BigDecimal getR0290_new_loan_in_month_resi() {
		return r0290_new_loan_in_month_resi;
	}
	public void setR0290_new_loan_in_month_resi(BigDecimal r0290_new_loan_in_month_resi) {
		this.r0290_new_loan_in_month_resi = r0290_new_loan_in_month_resi;
	}
	public BigDecimal getR0290_min_interest_rate_resi() {
		return r0290_min_interest_rate_resi;
	}
	public void setR0290_min_interest_rate_resi(BigDecimal r0290_min_interest_rate_resi) {
		this.r0290_min_interest_rate_resi = r0290_min_interest_rate_resi;
	}
	public BigDecimal getR0290_max_interest_rate_resi() {
		return r0290_max_interest_rate_resi;
	}
	public void setR0290_max_interest_rate_resi(BigDecimal r0290_max_interest_rate_resi) {
		this.r0290_max_interest_rate_resi = r0290_max_interest_rate_resi;
	}
	public BigDecimal getR0290_weighted_interest_resi() {
		return r0290_weighted_interest_resi;
	}
	public void setR0290_weighted_interest_resi(BigDecimal r0290_weighted_interest_resi) {
		this.r0290_weighted_interest_resi = r0290_weighted_interest_resi;
	}
	public BigDecimal getR0290_total_loan_outstanding_resi() {
		return r0290_total_loan_outstanding_resi;
	}
	public void setR0290_total_loan_outstanding_resi(BigDecimal r0290_total_loan_outstanding_resi) {
		this.r0290_total_loan_outstanding_resi = r0290_total_loan_outstanding_resi;
	}
	public BigDecimal getR0290_total_interest_income_resi() {
		return r0290_total_interest_income_resi;
	}
	public void setR0290_total_interest_income_resi(BigDecimal r0290_total_interest_income_resi) {
		this.r0290_total_interest_income_resi = r0290_total_interest_income_resi;
	}
	public BigDecimal getR0290_new_loan_in_month_nonresi() {
		return r0290_new_loan_in_month_nonresi;
	}
	public void setR0290_new_loan_in_month_nonresi(BigDecimal r0290_new_loan_in_month_nonresi) {
		this.r0290_new_loan_in_month_nonresi = r0290_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0290_min_interest_rate_nonresi() {
		return r0290_min_interest_rate_nonresi;
	}
	public void setR0290_min_interest_rate_nonresi(BigDecimal r0290_min_interest_rate_nonresi) {
		this.r0290_min_interest_rate_nonresi = r0290_min_interest_rate_nonresi;
	}
	public BigDecimal getR0290_max_interest_rate_nonresi() {
		return r0290_max_interest_rate_nonresi;
	}
	public void setR0290_max_interest_rate_nonresi(BigDecimal r0290_max_interest_rate_nonresi) {
		this.r0290_max_interest_rate_nonresi = r0290_max_interest_rate_nonresi;
	}
	public BigDecimal getR0290_weighted_interest_nonresi() {
		return r0290_weighted_interest_nonresi;
	}
	public void setR0290_weighted_interest_nonresi(BigDecimal r0290_weighted_interest_nonresi) {
		this.r0290_weighted_interest_nonresi = r0290_weighted_interest_nonresi;
	}
	public BigDecimal getR0290_total_loan_outstanding_nonresi() {
		return r0290_total_loan_outstanding_nonresi;
	}
	public void setR0290_total_loan_outstanding_nonresi(BigDecimal r0290_total_loan_outstanding_nonresi) {
		this.r0290_total_loan_outstanding_nonresi = r0290_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0290_total_interest_income_nonresi() {
		return r0290_total_interest_income_nonresi;
	}
	public void setR0290_total_interest_income_nonresi(BigDecimal r0290_total_interest_income_nonresi) {
		this.r0290_total_interest_income_nonresi = r0290_total_interest_income_nonresi;
	}
	public String getR0300_loantype() {
		return r0300_loantype;
	}
	public void setR0300_loantype(String r0300_loantype) {
		this.r0300_loantype = r0300_loantype;
	}
	public BigDecimal getR0300_new_loan_in_month_resi() {
		return r0300_new_loan_in_month_resi;
	}
	public void setR0300_new_loan_in_month_resi(BigDecimal r0300_new_loan_in_month_resi) {
		this.r0300_new_loan_in_month_resi = r0300_new_loan_in_month_resi;
	}
	public BigDecimal getR0300_min_interest_rate_resi() {
		return r0300_min_interest_rate_resi;
	}
	public void setR0300_min_interest_rate_resi(BigDecimal r0300_min_interest_rate_resi) {
		this.r0300_min_interest_rate_resi = r0300_min_interest_rate_resi;
	}
	public BigDecimal getR0300_max_interest_rate_resi() {
		return r0300_max_interest_rate_resi;
	}
	public void setR0300_max_interest_rate_resi(BigDecimal r0300_max_interest_rate_resi) {
		this.r0300_max_interest_rate_resi = r0300_max_interest_rate_resi;
	}
	public BigDecimal getR0300_weighted_interest_resi() {
		return r0300_weighted_interest_resi;
	}
	public void setR0300_weighted_interest_resi(BigDecimal r0300_weighted_interest_resi) {
		this.r0300_weighted_interest_resi = r0300_weighted_interest_resi;
	}
	public BigDecimal getR0300_total_loan_outstanding_resi() {
		return r0300_total_loan_outstanding_resi;
	}
	public void setR0300_total_loan_outstanding_resi(BigDecimal r0300_total_loan_outstanding_resi) {
		this.r0300_total_loan_outstanding_resi = r0300_total_loan_outstanding_resi;
	}
	public BigDecimal getR0300_total_interest_income_resi() {
		return r0300_total_interest_income_resi;
	}
	public void setR0300_total_interest_income_resi(BigDecimal r0300_total_interest_income_resi) {
		this.r0300_total_interest_income_resi = r0300_total_interest_income_resi;
	}
	public BigDecimal getR0300_new_loan_in_month_nonresi() {
		return r0300_new_loan_in_month_nonresi;
	}
	public void setR0300_new_loan_in_month_nonresi(BigDecimal r0300_new_loan_in_month_nonresi) {
		this.r0300_new_loan_in_month_nonresi = r0300_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0300_min_interest_rate_nonresi() {
		return r0300_min_interest_rate_nonresi;
	}
	public void setR0300_min_interest_rate_nonresi(BigDecimal r0300_min_interest_rate_nonresi) {
		this.r0300_min_interest_rate_nonresi = r0300_min_interest_rate_nonresi;
	}
	public BigDecimal getR0300_max_interest_rate_nonresi() {
		return r0300_max_interest_rate_nonresi;
	}
	public void setR0300_max_interest_rate_nonresi(BigDecimal r0300_max_interest_rate_nonresi) {
		this.r0300_max_interest_rate_nonresi = r0300_max_interest_rate_nonresi;
	}
	public BigDecimal getR0300_weighted_interest_nonresi() {
		return r0300_weighted_interest_nonresi;
	}
	public void setR0300_weighted_interest_nonresi(BigDecimal r0300_weighted_interest_nonresi) {
		this.r0300_weighted_interest_nonresi = r0300_weighted_interest_nonresi;
	}
	public BigDecimal getR0300_total_loan_outstanding_nonresi() {
		return r0300_total_loan_outstanding_nonresi;
	}
	public void setR0300_total_loan_outstanding_nonresi(BigDecimal r0300_total_loan_outstanding_nonresi) {
		this.r0300_total_loan_outstanding_nonresi = r0300_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0300_total_interest_income_nonresi() {
		return r0300_total_interest_income_nonresi;
	}
	public void setR0300_total_interest_income_nonresi(BigDecimal r0300_total_interest_income_nonresi) {
		this.r0300_total_interest_income_nonresi = r0300_total_interest_income_nonresi;
	}
	public String getR0310_loantype() {
		return r0310_loantype;
	}
	public void setR0310_loantype(String r0310_loantype) {
		this.r0310_loantype = r0310_loantype;
	}
	public BigDecimal getR0310_new_loan_in_month_resi() {
		return r0310_new_loan_in_month_resi;
	}
	public void setR0310_new_loan_in_month_resi(BigDecimal r0310_new_loan_in_month_resi) {
		this.r0310_new_loan_in_month_resi = r0310_new_loan_in_month_resi;
	}
	public BigDecimal getR0310_min_interest_rate_resi() {
		return r0310_min_interest_rate_resi;
	}
	public void setR0310_min_interest_rate_resi(BigDecimal r0310_min_interest_rate_resi) {
		this.r0310_min_interest_rate_resi = r0310_min_interest_rate_resi;
	}
	public BigDecimal getR0310_max_interest_rate_resi() {
		return r0310_max_interest_rate_resi;
	}
	public void setR0310_max_interest_rate_resi(BigDecimal r0310_max_interest_rate_resi) {
		this.r0310_max_interest_rate_resi = r0310_max_interest_rate_resi;
	}
	public BigDecimal getR0310_weighted_interest_resi() {
		return r0310_weighted_interest_resi;
	}
	public void setR0310_weighted_interest_resi(BigDecimal r0310_weighted_interest_resi) {
		this.r0310_weighted_interest_resi = r0310_weighted_interest_resi;
	}
	public BigDecimal getR0310_total_loan_outstanding_resi() {
		return r0310_total_loan_outstanding_resi;
	}
	public void setR0310_total_loan_outstanding_resi(BigDecimal r0310_total_loan_outstanding_resi) {
		this.r0310_total_loan_outstanding_resi = r0310_total_loan_outstanding_resi;
	}
	public BigDecimal getR0310_total_interest_income_resi() {
		return r0310_total_interest_income_resi;
	}
	public void setR0310_total_interest_income_resi(BigDecimal r0310_total_interest_income_resi) {
		this.r0310_total_interest_income_resi = r0310_total_interest_income_resi;
	}
	public BigDecimal getR0310_new_loan_in_month_nonresi() {
		return r0310_new_loan_in_month_nonresi;
	}
	public void setR0310_new_loan_in_month_nonresi(BigDecimal r0310_new_loan_in_month_nonresi) {
		this.r0310_new_loan_in_month_nonresi = r0310_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0310_min_interest_rate_nonresi() {
		return r0310_min_interest_rate_nonresi;
	}
	public void setR0310_min_interest_rate_nonresi(BigDecimal r0310_min_interest_rate_nonresi) {
		this.r0310_min_interest_rate_nonresi = r0310_min_interest_rate_nonresi;
	}
	public BigDecimal getR0310_max_interest_rate_nonresi() {
		return r0310_max_interest_rate_nonresi;
	}
	public void setR0310_max_interest_rate_nonresi(BigDecimal r0310_max_interest_rate_nonresi) {
		this.r0310_max_interest_rate_nonresi = r0310_max_interest_rate_nonresi;
	}
	public BigDecimal getR0310_weighted_interest_nonresi() {
		return r0310_weighted_interest_nonresi;
	}
	public void setR0310_weighted_interest_nonresi(BigDecimal r0310_weighted_interest_nonresi) {
		this.r0310_weighted_interest_nonresi = r0310_weighted_interest_nonresi;
	}
	public BigDecimal getR0310_total_loan_outstanding_nonresi() {
		return r0310_total_loan_outstanding_nonresi;
	}
	public void setR0310_total_loan_outstanding_nonresi(BigDecimal r0310_total_loan_outstanding_nonresi) {
		this.r0310_total_loan_outstanding_nonresi = r0310_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0310_total_interest_income_nonresi() {
		return r0310_total_interest_income_nonresi;
	}
	public void setR0310_total_interest_income_nonresi(BigDecimal r0310_total_interest_income_nonresi) {
		this.r0310_total_interest_income_nonresi = r0310_total_interest_income_nonresi;
	}
	public String getR0320_loantype() {
		return r0320_loantype;
	}
	public void setR0320_loantype(String r0320_loantype) {
		this.r0320_loantype = r0320_loantype;
	}
	public BigDecimal getR0320_new_loan_in_month_resi() {
		return r0320_new_loan_in_month_resi;
	}
	public void setR0320_new_loan_in_month_resi(BigDecimal r0320_new_loan_in_month_resi) {
		this.r0320_new_loan_in_month_resi = r0320_new_loan_in_month_resi;
	}
	public BigDecimal getR0320_min_interest_rate_resi() {
		return r0320_min_interest_rate_resi;
	}
	public void setR0320_min_interest_rate_resi(BigDecimal r0320_min_interest_rate_resi) {
		this.r0320_min_interest_rate_resi = r0320_min_interest_rate_resi;
	}
	public BigDecimal getR0320_max_interest_rate_resi() {
		return r0320_max_interest_rate_resi;
	}
	public void setR0320_max_interest_rate_resi(BigDecimal r0320_max_interest_rate_resi) {
		this.r0320_max_interest_rate_resi = r0320_max_interest_rate_resi;
	}
	public BigDecimal getR0320_weighted_interest_resi() {
		return r0320_weighted_interest_resi;
	}
	public void setR0320_weighted_interest_resi(BigDecimal r0320_weighted_interest_resi) {
		this.r0320_weighted_interest_resi = r0320_weighted_interest_resi;
	}
	public BigDecimal getR0320_total_loan_outstanding_resi() {
		return r0320_total_loan_outstanding_resi;
	}
	public void setR0320_total_loan_outstanding_resi(BigDecimal r0320_total_loan_outstanding_resi) {
		this.r0320_total_loan_outstanding_resi = r0320_total_loan_outstanding_resi;
	}
	public BigDecimal getR0320_total_interest_income_resi() {
		return r0320_total_interest_income_resi;
	}
	public void setR0320_total_interest_income_resi(BigDecimal r0320_total_interest_income_resi) {
		this.r0320_total_interest_income_resi = r0320_total_interest_income_resi;
	}
	public BigDecimal getR0320_new_loan_in_month_nonresi() {
		return r0320_new_loan_in_month_nonresi;
	}
	public void setR0320_new_loan_in_month_nonresi(BigDecimal r0320_new_loan_in_month_nonresi) {
		this.r0320_new_loan_in_month_nonresi = r0320_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0320_min_interest_rate_nonresi() {
		return r0320_min_interest_rate_nonresi;
	}
	public void setR0320_min_interest_rate_nonresi(BigDecimal r0320_min_interest_rate_nonresi) {
		this.r0320_min_interest_rate_nonresi = r0320_min_interest_rate_nonresi;
	}
	public BigDecimal getR0320_max_interest_rate_nonresi() {
		return r0320_max_interest_rate_nonresi;
	}
	public void setR0320_max_interest_rate_nonresi(BigDecimal r0320_max_interest_rate_nonresi) {
		this.r0320_max_interest_rate_nonresi = r0320_max_interest_rate_nonresi;
	}
	public BigDecimal getR0320_weighted_interest_nonresi() {
		return r0320_weighted_interest_nonresi;
	}
	public void setR0320_weighted_interest_nonresi(BigDecimal r0320_weighted_interest_nonresi) {
		this.r0320_weighted_interest_nonresi = r0320_weighted_interest_nonresi;
	}
	public BigDecimal getR0320_total_loan_outstanding_nonresi() {
		return r0320_total_loan_outstanding_nonresi;
	}
	public void setR0320_total_loan_outstanding_nonresi(BigDecimal r0320_total_loan_outstanding_nonresi) {
		this.r0320_total_loan_outstanding_nonresi = r0320_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0320_total_interest_income_nonresi() {
		return r0320_total_interest_income_nonresi;
	}
	public void setR0320_total_interest_income_nonresi(BigDecimal r0320_total_interest_income_nonresi) {
		this.r0320_total_interest_income_nonresi = r0320_total_interest_income_nonresi;
	}
	public String getR0330_loantype() {
		return r0330_loantype;
	}
	public void setR0330_loantype(String r0330_loantype) {
		this.r0330_loantype = r0330_loantype;
	}
	public BigDecimal getR0330_new_loan_in_month_resi() {
		return r0330_new_loan_in_month_resi;
	}
	public void setR0330_new_loan_in_month_resi(BigDecimal r0330_new_loan_in_month_resi) {
		this.r0330_new_loan_in_month_resi = r0330_new_loan_in_month_resi;
	}
	public BigDecimal getR0330_min_interest_rate_resi() {
		return r0330_min_interest_rate_resi;
	}
	public void setR0330_min_interest_rate_resi(BigDecimal r0330_min_interest_rate_resi) {
		this.r0330_min_interest_rate_resi = r0330_min_interest_rate_resi;
	}
	public BigDecimal getR0330_max_interest_rate_resi() {
		return r0330_max_interest_rate_resi;
	}
	public void setR0330_max_interest_rate_resi(BigDecimal r0330_max_interest_rate_resi) {
		this.r0330_max_interest_rate_resi = r0330_max_interest_rate_resi;
	}
	public BigDecimal getR0330_weighted_interest_resi() {
		return r0330_weighted_interest_resi;
	}
	public void setR0330_weighted_interest_resi(BigDecimal r0330_weighted_interest_resi) {
		this.r0330_weighted_interest_resi = r0330_weighted_interest_resi;
	}
	public BigDecimal getR0330_total_loan_outstanding_resi() {
		return r0330_total_loan_outstanding_resi;
	}
	public void setR0330_total_loan_outstanding_resi(BigDecimal r0330_total_loan_outstanding_resi) {
		this.r0330_total_loan_outstanding_resi = r0330_total_loan_outstanding_resi;
	}
	public BigDecimal getR0330_total_interest_income_resi() {
		return r0330_total_interest_income_resi;
	}
	public void setR0330_total_interest_income_resi(BigDecimal r0330_total_interest_income_resi) {
		this.r0330_total_interest_income_resi = r0330_total_interest_income_resi;
	}
	public BigDecimal getR0330_new_loan_in_month_nonresi() {
		return r0330_new_loan_in_month_nonresi;
	}
	public void setR0330_new_loan_in_month_nonresi(BigDecimal r0330_new_loan_in_month_nonresi) {
		this.r0330_new_loan_in_month_nonresi = r0330_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0330_min_interest_rate_nonresi() {
		return r0330_min_interest_rate_nonresi;
	}
	public void setR0330_min_interest_rate_nonresi(BigDecimal r0330_min_interest_rate_nonresi) {
		this.r0330_min_interest_rate_nonresi = r0330_min_interest_rate_nonresi;
	}
	public BigDecimal getR0330_max_interest_rate_nonresi() {
		return r0330_max_interest_rate_nonresi;
	}
	public void setR0330_max_interest_rate_nonresi(BigDecimal r0330_max_interest_rate_nonresi) {
		this.r0330_max_interest_rate_nonresi = r0330_max_interest_rate_nonresi;
	}
	public BigDecimal getR0330_weighted_interest_nonresi() {
		return r0330_weighted_interest_nonresi;
	}
	public void setR0330_weighted_interest_nonresi(BigDecimal r0330_weighted_interest_nonresi) {
		this.r0330_weighted_interest_nonresi = r0330_weighted_interest_nonresi;
	}
	public BigDecimal getR0330_total_loan_outstanding_nonresi() {
		return r0330_total_loan_outstanding_nonresi;
	}
	public void setR0330_total_loan_outstanding_nonresi(BigDecimal r0330_total_loan_outstanding_nonresi) {
		this.r0330_total_loan_outstanding_nonresi = r0330_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0330_total_interest_income_nonresi() {
		return r0330_total_interest_income_nonresi;
	}
	public void setR0330_total_interest_income_nonresi(BigDecimal r0330_total_interest_income_nonresi) {
		this.r0330_total_interest_income_nonresi = r0330_total_interest_income_nonresi;
	}
	public String getR0340_loantype() {
		return r0340_loantype;
	}
	public void setR0340_loantype(String r0340_loantype) {
		this.r0340_loantype = r0340_loantype;
	}
	public String getR0350_loantype() {
		return r0350_loantype;
	}
	public void setR0350_loantype(String r0350_loantype) {
		this.r0350_loantype = r0350_loantype;
	}
	public BigDecimal getR0350_new_loan_in_month_resi() {
		return r0350_new_loan_in_month_resi;
	}
	public void setR0350_new_loan_in_month_resi(BigDecimal r0350_new_loan_in_month_resi) {
		this.r0350_new_loan_in_month_resi = r0350_new_loan_in_month_resi;
	}
	public BigDecimal getR0350_min_interest_rate_resi() {
		return r0350_min_interest_rate_resi;
	}
	public void setR0350_min_interest_rate_resi(BigDecimal r0350_min_interest_rate_resi) {
		this.r0350_min_interest_rate_resi = r0350_min_interest_rate_resi;
	}
	public BigDecimal getR0350_max_interest_rate_resi() {
		return r0350_max_interest_rate_resi;
	}
	public void setR0350_max_interest_rate_resi(BigDecimal r0350_max_interest_rate_resi) {
		this.r0350_max_interest_rate_resi = r0350_max_interest_rate_resi;
	}
	public BigDecimal getR0350_weighted_interest_resi() {
		return r0350_weighted_interest_resi;
	}
	public void setR0350_weighted_interest_resi(BigDecimal r0350_weighted_interest_resi) {
		this.r0350_weighted_interest_resi = r0350_weighted_interest_resi;
	}
	public BigDecimal getR0350_total_loan_outstanding_resi() {
		return r0350_total_loan_outstanding_resi;
	}
	public void setR0350_total_loan_outstanding_resi(BigDecimal r0350_total_loan_outstanding_resi) {
		this.r0350_total_loan_outstanding_resi = r0350_total_loan_outstanding_resi;
	}
	public BigDecimal getR0350_total_interest_income_resi() {
		return r0350_total_interest_income_resi;
	}
	public void setR0350_total_interest_income_resi(BigDecimal r0350_total_interest_income_resi) {
		this.r0350_total_interest_income_resi = r0350_total_interest_income_resi;
	}
	public BigDecimal getR0350_new_loan_in_month_nonresi() {
		return r0350_new_loan_in_month_nonresi;
	}
	public void setR0350_new_loan_in_month_nonresi(BigDecimal r0350_new_loan_in_month_nonresi) {
		this.r0350_new_loan_in_month_nonresi = r0350_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0350_min_interest_rate_nonresi() {
		return r0350_min_interest_rate_nonresi;
	}
	public void setR0350_min_interest_rate_nonresi(BigDecimal r0350_min_interest_rate_nonresi) {
		this.r0350_min_interest_rate_nonresi = r0350_min_interest_rate_nonresi;
	}
	public BigDecimal getR0350_max_interest_rate_nonresi() {
		return r0350_max_interest_rate_nonresi;
	}
	public void setR0350_max_interest_rate_nonresi(BigDecimal r0350_max_interest_rate_nonresi) {
		this.r0350_max_interest_rate_nonresi = r0350_max_interest_rate_nonresi;
	}
	public BigDecimal getR0350_weighted_interest_nonresi() {
		return r0350_weighted_interest_nonresi;
	}
	public void setR0350_weighted_interest_nonresi(BigDecimal r0350_weighted_interest_nonresi) {
		this.r0350_weighted_interest_nonresi = r0350_weighted_interest_nonresi;
	}
	public BigDecimal getR0350_total_loan_outstanding_nonresi() {
		return r0350_total_loan_outstanding_nonresi;
	}
	public void setR0350_total_loan_outstanding_nonresi(BigDecimal r0350_total_loan_outstanding_nonresi) {
		this.r0350_total_loan_outstanding_nonresi = r0350_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0350_total_interest_income_nonresi() {
		return r0350_total_interest_income_nonresi;
	}
	public void setR0350_total_interest_income_nonresi(BigDecimal r0350_total_interest_income_nonresi) {
		this.r0350_total_interest_income_nonresi = r0350_total_interest_income_nonresi;
	}
	public String getR0360_loantype() {
		return r0360_loantype;
	}
	public void setR0360_loantype(String r0360_loantype) {
		this.r0360_loantype = r0360_loantype;
	}
	public BigDecimal getR0360_new_loan_in_month_resi() {
		return r0360_new_loan_in_month_resi;
	}
	public void setR0360_new_loan_in_month_resi(BigDecimal r0360_new_loan_in_month_resi) {
		this.r0360_new_loan_in_month_resi = r0360_new_loan_in_month_resi;
	}
	public BigDecimal getR0360_min_interest_rate_resi() {
		return r0360_min_interest_rate_resi;
	}
	public void setR0360_min_interest_rate_resi(BigDecimal r0360_min_interest_rate_resi) {
		this.r0360_min_interest_rate_resi = r0360_min_interest_rate_resi;
	}
	public BigDecimal getR0360_max_interest_rate_resi() {
		return r0360_max_interest_rate_resi;
	}
	public void setR0360_max_interest_rate_resi(BigDecimal r0360_max_interest_rate_resi) {
		this.r0360_max_interest_rate_resi = r0360_max_interest_rate_resi;
	}
	public BigDecimal getR0360_weighted_interest_resi() {
		return r0360_weighted_interest_resi;
	}
	public void setR0360_weighted_interest_resi(BigDecimal r0360_weighted_interest_resi) {
		this.r0360_weighted_interest_resi = r0360_weighted_interest_resi;
	}
	public BigDecimal getR0360_total_loan_outstanding_resi() {
		return r0360_total_loan_outstanding_resi;
	}
	public void setR0360_total_loan_outstanding_resi(BigDecimal r0360_total_loan_outstanding_resi) {
		this.r0360_total_loan_outstanding_resi = r0360_total_loan_outstanding_resi;
	}
	public BigDecimal getR0360_total_interest_income_resi() {
		return r0360_total_interest_income_resi;
	}
	public void setR0360_total_interest_income_resi(BigDecimal r0360_total_interest_income_resi) {
		this.r0360_total_interest_income_resi = r0360_total_interest_income_resi;
	}
	public BigDecimal getR0360_new_loan_in_month_nonresi() {
		return r0360_new_loan_in_month_nonresi;
	}
	public void setR0360_new_loan_in_month_nonresi(BigDecimal r0360_new_loan_in_month_nonresi) {
		this.r0360_new_loan_in_month_nonresi = r0360_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0360_min_interest_rate_nonresi() {
		return r0360_min_interest_rate_nonresi;
	}
	public void setR0360_min_interest_rate_nonresi(BigDecimal r0360_min_interest_rate_nonresi) {
		this.r0360_min_interest_rate_nonresi = r0360_min_interest_rate_nonresi;
	}
	public BigDecimal getR0360_max_interest_rate_nonresi() {
		return r0360_max_interest_rate_nonresi;
	}
	public void setR0360_max_interest_rate_nonresi(BigDecimal r0360_max_interest_rate_nonresi) {
		this.r0360_max_interest_rate_nonresi = r0360_max_interest_rate_nonresi;
	}
	public BigDecimal getR0360_weighted_interest_nonresi() {
		return r0360_weighted_interest_nonresi;
	}
	public void setR0360_weighted_interest_nonresi(BigDecimal r0360_weighted_interest_nonresi) {
		this.r0360_weighted_interest_nonresi = r0360_weighted_interest_nonresi;
	}
	public BigDecimal getR0360_total_loan_outstanding_nonresi() {
		return r0360_total_loan_outstanding_nonresi;
	}
	public void setR0360_total_loan_outstanding_nonresi(BigDecimal r0360_total_loan_outstanding_nonresi) {
		this.r0360_total_loan_outstanding_nonresi = r0360_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0360_total_interest_income_nonresi() {
		return r0360_total_interest_income_nonresi;
	}
	public void setR0360_total_interest_income_nonresi(BigDecimal r0360_total_interest_income_nonresi) {
		this.r0360_total_interest_income_nonresi = r0360_total_interest_income_nonresi;
	}
	public String getR0370_loantype() {
		return r0370_loantype;
	}
	public void setR0370_loantype(String r0370_loantype) {
		this.r0370_loantype = r0370_loantype;
	}
	public BigDecimal getR0370_new_loan_in_month_resi() {
		return r0370_new_loan_in_month_resi;
	}
	public void setR0370_new_loan_in_month_resi(BigDecimal r0370_new_loan_in_month_resi) {
		this.r0370_new_loan_in_month_resi = r0370_new_loan_in_month_resi;
	}
	public BigDecimal getR0370_min_interest_rate_resi() {
		return r0370_min_interest_rate_resi;
	}
	public void setR0370_min_interest_rate_resi(BigDecimal r0370_min_interest_rate_resi) {
		this.r0370_min_interest_rate_resi = r0370_min_interest_rate_resi;
	}
	public BigDecimal getR0370_max_interest_rate_resi() {
		return r0370_max_interest_rate_resi;
	}
	public void setR0370_max_interest_rate_resi(BigDecimal r0370_max_interest_rate_resi) {
		this.r0370_max_interest_rate_resi = r0370_max_interest_rate_resi;
	}
	public BigDecimal getR0370_weighted_interest_resi() {
		return r0370_weighted_interest_resi;
	}
	public void setR0370_weighted_interest_resi(BigDecimal r0370_weighted_interest_resi) {
		this.r0370_weighted_interest_resi = r0370_weighted_interest_resi;
	}
	public BigDecimal getR0370_total_loan_outstanding_resi() {
		return r0370_total_loan_outstanding_resi;
	}
	public void setR0370_total_loan_outstanding_resi(BigDecimal r0370_total_loan_outstanding_resi) {
		this.r0370_total_loan_outstanding_resi = r0370_total_loan_outstanding_resi;
	}
	public BigDecimal getR0370_total_interest_income_resi() {
		return r0370_total_interest_income_resi;
	}
	public void setR0370_total_interest_income_resi(BigDecimal r0370_total_interest_income_resi) {
		this.r0370_total_interest_income_resi = r0370_total_interest_income_resi;
	}
	public BigDecimal getR0370_new_loan_in_month_nonresi() {
		return r0370_new_loan_in_month_nonresi;
	}
	public void setR0370_new_loan_in_month_nonresi(BigDecimal r0370_new_loan_in_month_nonresi) {
		this.r0370_new_loan_in_month_nonresi = r0370_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0370_min_interest_rate_nonresi() {
		return r0370_min_interest_rate_nonresi;
	}
	public void setR0370_min_interest_rate_nonresi(BigDecimal r0370_min_interest_rate_nonresi) {
		this.r0370_min_interest_rate_nonresi = r0370_min_interest_rate_nonresi;
	}
	public BigDecimal getR0370_max_interest_rate_nonresi() {
		return r0370_max_interest_rate_nonresi;
	}
	public void setR0370_max_interest_rate_nonresi(BigDecimal r0370_max_interest_rate_nonresi) {
		this.r0370_max_interest_rate_nonresi = r0370_max_interest_rate_nonresi;
	}
	public BigDecimal getR0370_weighted_interest_nonresi() {
		return r0370_weighted_interest_nonresi;
	}
	public void setR0370_weighted_interest_nonresi(BigDecimal r0370_weighted_interest_nonresi) {
		this.r0370_weighted_interest_nonresi = r0370_weighted_interest_nonresi;
	}
	public BigDecimal getR0370_total_loan_outstanding_nonresi() {
		return r0370_total_loan_outstanding_nonresi;
	}
	public void setR0370_total_loan_outstanding_nonresi(BigDecimal r0370_total_loan_outstanding_nonresi) {
		this.r0370_total_loan_outstanding_nonresi = r0370_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0370_total_interest_income_nonresi() {
		return r0370_total_interest_income_nonresi;
	}
	public void setR0370_total_interest_income_nonresi(BigDecimal r0370_total_interest_income_nonresi) {
		this.r0370_total_interest_income_nonresi = r0370_total_interest_income_nonresi;
	}
	public String getR0380_loantype() {
		return r0380_loantype;
	}
	public void setR0380_loantype(String r0380_loantype) {
		this.r0380_loantype = r0380_loantype;
	}
	public BigDecimal getR0380_new_loan_in_month_resi() {
		return r0380_new_loan_in_month_resi;
	}
	public void setR0380_new_loan_in_month_resi(BigDecimal r0380_new_loan_in_month_resi) {
		this.r0380_new_loan_in_month_resi = r0380_new_loan_in_month_resi;
	}
	public BigDecimal getR0380_min_interest_rate_resi() {
		return r0380_min_interest_rate_resi;
	}
	public void setR0380_min_interest_rate_resi(BigDecimal r0380_min_interest_rate_resi) {
		this.r0380_min_interest_rate_resi = r0380_min_interest_rate_resi;
	}
	public BigDecimal getR0380_max_interest_rate_resi() {
		return r0380_max_interest_rate_resi;
	}
	public void setR0380_max_interest_rate_resi(BigDecimal r0380_max_interest_rate_resi) {
		this.r0380_max_interest_rate_resi = r0380_max_interest_rate_resi;
	}
	public BigDecimal getR0380_weighted_interest_resi() {
		return r0380_weighted_interest_resi;
	}
	public void setR0380_weighted_interest_resi(BigDecimal r0380_weighted_interest_resi) {
		this.r0380_weighted_interest_resi = r0380_weighted_interest_resi;
	}
	public BigDecimal getR0380_total_loan_outstanding_resi() {
		return r0380_total_loan_outstanding_resi;
	}
	public void setR0380_total_loan_outstanding_resi(BigDecimal r0380_total_loan_outstanding_resi) {
		this.r0380_total_loan_outstanding_resi = r0380_total_loan_outstanding_resi;
	}
	public BigDecimal getR0380_total_interest_income_resi() {
		return r0380_total_interest_income_resi;
	}
	public void setR0380_total_interest_income_resi(BigDecimal r0380_total_interest_income_resi) {
		this.r0380_total_interest_income_resi = r0380_total_interest_income_resi;
	}
	public BigDecimal getR0380_new_loan_in_month_nonresi() {
		return r0380_new_loan_in_month_nonresi;
	}
	public void setR0380_new_loan_in_month_nonresi(BigDecimal r0380_new_loan_in_month_nonresi) {
		this.r0380_new_loan_in_month_nonresi = r0380_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0380_min_interest_rate_nonresi() {
		return r0380_min_interest_rate_nonresi;
	}
	public void setR0380_min_interest_rate_nonresi(BigDecimal r0380_min_interest_rate_nonresi) {
		this.r0380_min_interest_rate_nonresi = r0380_min_interest_rate_nonresi;
	}
	public BigDecimal getR0380_max_interest_rate_nonresi() {
		return r0380_max_interest_rate_nonresi;
	}
	public void setR0380_max_interest_rate_nonresi(BigDecimal r0380_max_interest_rate_nonresi) {
		this.r0380_max_interest_rate_nonresi = r0380_max_interest_rate_nonresi;
	}
	public BigDecimal getR0380_weighted_interest_nonresi() {
		return r0380_weighted_interest_nonresi;
	}
	public void setR0380_weighted_interest_nonresi(BigDecimal r0380_weighted_interest_nonresi) {
		this.r0380_weighted_interest_nonresi = r0380_weighted_interest_nonresi;
	}
	public BigDecimal getR0380_total_loan_outstanding_nonresi() {
		return r0380_total_loan_outstanding_nonresi;
	}
	public void setR0380_total_loan_outstanding_nonresi(BigDecimal r0380_total_loan_outstanding_nonresi) {
		this.r0380_total_loan_outstanding_nonresi = r0380_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0380_total_interest_income_nonresi() {
		return r0380_total_interest_income_nonresi;
	}
	public void setR0380_total_interest_income_nonresi(BigDecimal r0380_total_interest_income_nonresi) {
		this.r0380_total_interest_income_nonresi = r0380_total_interest_income_nonresi;
	}
	public String getR0390_loantype() {
		return r0390_loantype;
	}
	public void setR0390_loantype(String r0390_loantype) {
		this.r0390_loantype = r0390_loantype;
	}
	public BigDecimal getR0390_new_loan_in_month_resi() {
		return r0390_new_loan_in_month_resi;
	}
	public void setR0390_new_loan_in_month_resi(BigDecimal r0390_new_loan_in_month_resi) {
		this.r0390_new_loan_in_month_resi = r0390_new_loan_in_month_resi;
	}
	public BigDecimal getR0390_min_interest_rate_resi() {
		return r0390_min_interest_rate_resi;
	}
	public void setR0390_min_interest_rate_resi(BigDecimal r0390_min_interest_rate_resi) {
		this.r0390_min_interest_rate_resi = r0390_min_interest_rate_resi;
	}
	public BigDecimal getR0390_max_interest_rate_resi() {
		return r0390_max_interest_rate_resi;
	}
	public void setR0390_max_interest_rate_resi(BigDecimal r0390_max_interest_rate_resi) {
		this.r0390_max_interest_rate_resi = r0390_max_interest_rate_resi;
	}
	public BigDecimal getR0390_weighted_interest_resi() {
		return r0390_weighted_interest_resi;
	}
	public void setR0390_weighted_interest_resi(BigDecimal r0390_weighted_interest_resi) {
		this.r0390_weighted_interest_resi = r0390_weighted_interest_resi;
	}
	public BigDecimal getR0390_total_loan_outstanding_resi() {
		return r0390_total_loan_outstanding_resi;
	}
	public void setR0390_total_loan_outstanding_resi(BigDecimal r0390_total_loan_outstanding_resi) {
		this.r0390_total_loan_outstanding_resi = r0390_total_loan_outstanding_resi;
	}
	public BigDecimal getR0390_total_interest_income_resi() {
		return r0390_total_interest_income_resi;
	}
	public void setR0390_total_interest_income_resi(BigDecimal r0390_total_interest_income_resi) {
		this.r0390_total_interest_income_resi = r0390_total_interest_income_resi;
	}
	public BigDecimal getR0390_new_loan_in_month_nonresi() {
		return r0390_new_loan_in_month_nonresi;
	}
	public void setR0390_new_loan_in_month_nonresi(BigDecimal r0390_new_loan_in_month_nonresi) {
		this.r0390_new_loan_in_month_nonresi = r0390_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0390_min_interest_rate_nonresi() {
		return r0390_min_interest_rate_nonresi;
	}
	public void setR0390_min_interest_rate_nonresi(BigDecimal r0390_min_interest_rate_nonresi) {
		this.r0390_min_interest_rate_nonresi = r0390_min_interest_rate_nonresi;
	}
	public BigDecimal getR0390_max_interest_rate_nonresi() {
		return r0390_max_interest_rate_nonresi;
	}
	public void setR0390_max_interest_rate_nonresi(BigDecimal r0390_max_interest_rate_nonresi) {
		this.r0390_max_interest_rate_nonresi = r0390_max_interest_rate_nonresi;
	}
	public BigDecimal getR0390_weighted_interest_nonresi() {
		return r0390_weighted_interest_nonresi;
	}
	public void setR0390_weighted_interest_nonresi(BigDecimal r0390_weighted_interest_nonresi) {
		this.r0390_weighted_interest_nonresi = r0390_weighted_interest_nonresi;
	}
	public BigDecimal getR0390_total_loan_outstanding_nonresi() {
		return r0390_total_loan_outstanding_nonresi;
	}
	public void setR0390_total_loan_outstanding_nonresi(BigDecimal r0390_total_loan_outstanding_nonresi) {
		this.r0390_total_loan_outstanding_nonresi = r0390_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0390_total_interest_income_nonresi() {
		return r0390_total_interest_income_nonresi;
	}
	public void setR0390_total_interest_income_nonresi(BigDecimal r0390_total_interest_income_nonresi) {
		this.r0390_total_interest_income_nonresi = r0390_total_interest_income_nonresi;
	}
	public String getR0400_loantype() {
		return r0400_loantype;
	}
	public void setR0400_loantype(String r0400_loantype) {
		this.r0400_loantype = r0400_loantype;
	}
	public BigDecimal getR0400_new_loan_in_month_resi() {
		return r0400_new_loan_in_month_resi;
	}
	public void setR0400_new_loan_in_month_resi(BigDecimal r0400_new_loan_in_month_resi) {
		this.r0400_new_loan_in_month_resi = r0400_new_loan_in_month_resi;
	}
	public BigDecimal getR0400_min_interest_rate_resi() {
		return r0400_min_interest_rate_resi;
	}
	public void setR0400_min_interest_rate_resi(BigDecimal r0400_min_interest_rate_resi) {
		this.r0400_min_interest_rate_resi = r0400_min_interest_rate_resi;
	}
	public BigDecimal getR0400_max_interest_rate_resi() {
		return r0400_max_interest_rate_resi;
	}
	public void setR0400_max_interest_rate_resi(BigDecimal r0400_max_interest_rate_resi) {
		this.r0400_max_interest_rate_resi = r0400_max_interest_rate_resi;
	}
	public BigDecimal getR0400_weighted_interest_resi() {
		return r0400_weighted_interest_resi;
	}
	public void setR0400_weighted_interest_resi(BigDecimal r0400_weighted_interest_resi) {
		this.r0400_weighted_interest_resi = r0400_weighted_interest_resi;
	}
	public BigDecimal getR0400_total_loan_outstanding_resi() {
		return r0400_total_loan_outstanding_resi;
	}
	public void setR0400_total_loan_outstanding_resi(BigDecimal r0400_total_loan_outstanding_resi) {
		this.r0400_total_loan_outstanding_resi = r0400_total_loan_outstanding_resi;
	}
	public BigDecimal getR0400_total_interest_income_resi() {
		return r0400_total_interest_income_resi;
	}
	public void setR0400_total_interest_income_resi(BigDecimal r0400_total_interest_income_resi) {
		this.r0400_total_interest_income_resi = r0400_total_interest_income_resi;
	}
	public BigDecimal getR0400_new_loan_in_month_nonresi() {
		return r0400_new_loan_in_month_nonresi;
	}
	public void setR0400_new_loan_in_month_nonresi(BigDecimal r0400_new_loan_in_month_nonresi) {
		this.r0400_new_loan_in_month_nonresi = r0400_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0400_min_interest_rate_nonresi() {
		return r0400_min_interest_rate_nonresi;
	}
	public void setR0400_min_interest_rate_nonresi(BigDecimal r0400_min_interest_rate_nonresi) {
		this.r0400_min_interest_rate_nonresi = r0400_min_interest_rate_nonresi;
	}
	public BigDecimal getR0400_max_interest_rate_nonresi() {
		return r0400_max_interest_rate_nonresi;
	}
	public void setR0400_max_interest_rate_nonresi(BigDecimal r0400_max_interest_rate_nonresi) {
		this.r0400_max_interest_rate_nonresi = r0400_max_interest_rate_nonresi;
	}
	public BigDecimal getR0400_weighted_interest_nonresi() {
		return r0400_weighted_interest_nonresi;
	}
	public void setR0400_weighted_interest_nonresi(BigDecimal r0400_weighted_interest_nonresi) {
		this.r0400_weighted_interest_nonresi = r0400_weighted_interest_nonresi;
	}
	public BigDecimal getR0400_total_loan_outstanding_nonresi() {
		return r0400_total_loan_outstanding_nonresi;
	}
	public void setR0400_total_loan_outstanding_nonresi(BigDecimal r0400_total_loan_outstanding_nonresi) {
		this.r0400_total_loan_outstanding_nonresi = r0400_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0400_total_interest_income_nonresi() {
		return r0400_total_interest_income_nonresi;
	}
	public void setR0400_total_interest_income_nonresi(BigDecimal r0400_total_interest_income_nonresi) {
		this.r0400_total_interest_income_nonresi = r0400_total_interest_income_nonresi;
	}
	public String getR0410_loantype() {
		return r0410_loantype;
	}
	public void setR0410_loantype(String r0410_loantype) {
		this.r0410_loantype = r0410_loantype;
	}
	public BigDecimal getR0410_new_loan_in_month_resi() {
		return r0410_new_loan_in_month_resi;
	}
	public void setR0410_new_loan_in_month_resi(BigDecimal r0410_new_loan_in_month_resi) {
		this.r0410_new_loan_in_month_resi = r0410_new_loan_in_month_resi;
	}
	public BigDecimal getR0410_min_interest_rate_resi() {
		return r0410_min_interest_rate_resi;
	}
	public void setR0410_min_interest_rate_resi(BigDecimal r0410_min_interest_rate_resi) {
		this.r0410_min_interest_rate_resi = r0410_min_interest_rate_resi;
	}
	public BigDecimal getR0410_max_interest_rate_resi() {
		return r0410_max_interest_rate_resi;
	}
	public void setR0410_max_interest_rate_resi(BigDecimal r0410_max_interest_rate_resi) {
		this.r0410_max_interest_rate_resi = r0410_max_interest_rate_resi;
	}
	public BigDecimal getR0410_weighted_interest_resi() {
		return r0410_weighted_interest_resi;
	}
	public void setR0410_weighted_interest_resi(BigDecimal r0410_weighted_interest_resi) {
		this.r0410_weighted_interest_resi = r0410_weighted_interest_resi;
	}
	public BigDecimal getR0410_total_loan_outstanding_resi() {
		return r0410_total_loan_outstanding_resi;
	}
	public void setR0410_total_loan_outstanding_resi(BigDecimal r0410_total_loan_outstanding_resi) {
		this.r0410_total_loan_outstanding_resi = r0410_total_loan_outstanding_resi;
	}
	public BigDecimal getR0410_total_interest_income_resi() {
		return r0410_total_interest_income_resi;
	}
	public void setR0410_total_interest_income_resi(BigDecimal r0410_total_interest_income_resi) {
		this.r0410_total_interest_income_resi = r0410_total_interest_income_resi;
	}
	public BigDecimal getR0410_new_loan_in_month_nonresi() {
		return r0410_new_loan_in_month_nonresi;
	}
	public void setR0410_new_loan_in_month_nonresi(BigDecimal r0410_new_loan_in_month_nonresi) {
		this.r0410_new_loan_in_month_nonresi = r0410_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0410_min_interest_rate_nonresi() {
		return r0410_min_interest_rate_nonresi;
	}
	public void setR0410_min_interest_rate_nonresi(BigDecimal r0410_min_interest_rate_nonresi) {
		this.r0410_min_interest_rate_nonresi = r0410_min_interest_rate_nonresi;
	}
	public BigDecimal getR0410_max_interest_rate_nonresi() {
		return r0410_max_interest_rate_nonresi;
	}
	public void setR0410_max_interest_rate_nonresi(BigDecimal r0410_max_interest_rate_nonresi) {
		this.r0410_max_interest_rate_nonresi = r0410_max_interest_rate_nonresi;
	}
	public BigDecimal getR0410_weighted_interest_nonresi() {
		return r0410_weighted_interest_nonresi;
	}
	public void setR0410_weighted_interest_nonresi(BigDecimal r0410_weighted_interest_nonresi) {
		this.r0410_weighted_interest_nonresi = r0410_weighted_interest_nonresi;
	}
	public BigDecimal getR0410_total_loan_outstanding_nonresi() {
		return r0410_total_loan_outstanding_nonresi;
	}
	public void setR0410_total_loan_outstanding_nonresi(BigDecimal r0410_total_loan_outstanding_nonresi) {
		this.r0410_total_loan_outstanding_nonresi = r0410_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0410_total_interest_income_nonresi() {
		return r0410_total_interest_income_nonresi;
	}
	public void setR0410_total_interest_income_nonresi(BigDecimal r0410_total_interest_income_nonresi) {
		this.r0410_total_interest_income_nonresi = r0410_total_interest_income_nonresi;
	}
	public String getR0420_loantype() {
		return r0420_loantype;
	}
	public void setR0420_loantype(String r0420_loantype) {
		this.r0420_loantype = r0420_loantype;
	}
	public BigDecimal getR0420_new_loan_in_month_resi() {
		return r0420_new_loan_in_month_resi;
	}
	public void setR0420_new_loan_in_month_resi(BigDecimal r0420_new_loan_in_month_resi) {
		this.r0420_new_loan_in_month_resi = r0420_new_loan_in_month_resi;
	}
	public BigDecimal getR0420_min_interest_rate_resi() {
		return r0420_min_interest_rate_resi;
	}
	public void setR0420_min_interest_rate_resi(BigDecimal r0420_min_interest_rate_resi) {
		this.r0420_min_interest_rate_resi = r0420_min_interest_rate_resi;
	}
	public BigDecimal getR0420_max_interest_rate_resi() {
		return r0420_max_interest_rate_resi;
	}
	public void setR0420_max_interest_rate_resi(BigDecimal r0420_max_interest_rate_resi) {
		this.r0420_max_interest_rate_resi = r0420_max_interest_rate_resi;
	}
	public BigDecimal getR0420_weighted_interest_resi() {
		return r0420_weighted_interest_resi;
	}
	public void setR0420_weighted_interest_resi(BigDecimal r0420_weighted_interest_resi) {
		this.r0420_weighted_interest_resi = r0420_weighted_interest_resi;
	}
	public BigDecimal getR0420_total_loan_outstanding_resi() {
		return r0420_total_loan_outstanding_resi;
	}
	public void setR0420_total_loan_outstanding_resi(BigDecimal r0420_total_loan_outstanding_resi) {
		this.r0420_total_loan_outstanding_resi = r0420_total_loan_outstanding_resi;
	}
	public BigDecimal getR0420_total_interest_income_resi() {
		return r0420_total_interest_income_resi;
	}
	public void setR0420_total_interest_income_resi(BigDecimal r0420_total_interest_income_resi) {
		this.r0420_total_interest_income_resi = r0420_total_interest_income_resi;
	}
	public BigDecimal getR0420_new_loan_in_month_nonresi() {
		return r0420_new_loan_in_month_nonresi;
	}
	public void setR0420_new_loan_in_month_nonresi(BigDecimal r0420_new_loan_in_month_nonresi) {
		this.r0420_new_loan_in_month_nonresi = r0420_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0420_min_interest_rate_nonresi() {
		return r0420_min_interest_rate_nonresi;
	}
	public void setR0420_min_interest_rate_nonresi(BigDecimal r0420_min_interest_rate_nonresi) {
		this.r0420_min_interest_rate_nonresi = r0420_min_interest_rate_nonresi;
	}
	public BigDecimal getR0420_max_interest_rate_nonresi() {
		return r0420_max_interest_rate_nonresi;
	}
	public void setR0420_max_interest_rate_nonresi(BigDecimal r0420_max_interest_rate_nonresi) {
		this.r0420_max_interest_rate_nonresi = r0420_max_interest_rate_nonresi;
	}
	public BigDecimal getR0420_weighted_interest_nonresi() {
		return r0420_weighted_interest_nonresi;
	}
	public void setR0420_weighted_interest_nonresi(BigDecimal r0420_weighted_interest_nonresi) {
		this.r0420_weighted_interest_nonresi = r0420_weighted_interest_nonresi;
	}
	public BigDecimal getR0420_total_loan_outstanding_nonresi() {
		return r0420_total_loan_outstanding_nonresi;
	}
	public void setR0420_total_loan_outstanding_nonresi(BigDecimal r0420_total_loan_outstanding_nonresi) {
		this.r0420_total_loan_outstanding_nonresi = r0420_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0420_total_interest_income_nonresi() {
		return r0420_total_interest_income_nonresi;
	}
	public void setR0420_total_interest_income_nonresi(BigDecimal r0420_total_interest_income_nonresi) {
		this.r0420_total_interest_income_nonresi = r0420_total_interest_income_nonresi;
	}
	public String getR0430_loantype() {
		return r0430_loantype;
	}
	public void setR0430_loantype(String r0430_loantype) {
		this.r0430_loantype = r0430_loantype;
	}
	public BigDecimal getR0430_new_loan_in_month_resi() {
		return r0430_new_loan_in_month_resi;
	}
	public void setR0430_new_loan_in_month_resi(BigDecimal r0430_new_loan_in_month_resi) {
		this.r0430_new_loan_in_month_resi = r0430_new_loan_in_month_resi;
	}
	public BigDecimal getR0430_min_interest_rate_resi() {
		return r0430_min_interest_rate_resi;
	}
	public void setR0430_min_interest_rate_resi(BigDecimal r0430_min_interest_rate_resi) {
		this.r0430_min_interest_rate_resi = r0430_min_interest_rate_resi;
	}
	public BigDecimal getR0430_max_interest_rate_resi() {
		return r0430_max_interest_rate_resi;
	}
	public void setR0430_max_interest_rate_resi(BigDecimal r0430_max_interest_rate_resi) {
		this.r0430_max_interest_rate_resi = r0430_max_interest_rate_resi;
	}
	public BigDecimal getR0430_weighted_interest_resi() {
		return r0430_weighted_interest_resi;
	}
	public void setR0430_weighted_interest_resi(BigDecimal r0430_weighted_interest_resi) {
		this.r0430_weighted_interest_resi = r0430_weighted_interest_resi;
	}
	public BigDecimal getR0430_total_loan_outstanding_resi() {
		return r0430_total_loan_outstanding_resi;
	}
	public void setR0430_total_loan_outstanding_resi(BigDecimal r0430_total_loan_outstanding_resi) {
		this.r0430_total_loan_outstanding_resi = r0430_total_loan_outstanding_resi;
	}
	public BigDecimal getR0430_total_interest_income_resi() {
		return r0430_total_interest_income_resi;
	}
	public void setR0430_total_interest_income_resi(BigDecimal r0430_total_interest_income_resi) {
		this.r0430_total_interest_income_resi = r0430_total_interest_income_resi;
	}
	public BigDecimal getR0430_new_loan_in_month_nonresi() {
		return r0430_new_loan_in_month_nonresi;
	}
	public void setR0430_new_loan_in_month_nonresi(BigDecimal r0430_new_loan_in_month_nonresi) {
		this.r0430_new_loan_in_month_nonresi = r0430_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0430_min_interest_rate_nonresi() {
		return r0430_min_interest_rate_nonresi;
	}
	public void setR0430_min_interest_rate_nonresi(BigDecimal r0430_min_interest_rate_nonresi) {
		this.r0430_min_interest_rate_nonresi = r0430_min_interest_rate_nonresi;
	}
	public BigDecimal getR0430_max_interest_rate_nonresi() {
		return r0430_max_interest_rate_nonresi;
	}
	public void setR0430_max_interest_rate_nonresi(BigDecimal r0430_max_interest_rate_nonresi) {
		this.r0430_max_interest_rate_nonresi = r0430_max_interest_rate_nonresi;
	}
	public BigDecimal getR0430_weighted_interest_nonresi() {
		return r0430_weighted_interest_nonresi;
	}
	public void setR0430_weighted_interest_nonresi(BigDecimal r0430_weighted_interest_nonresi) {
		this.r0430_weighted_interest_nonresi = r0430_weighted_interest_nonresi;
	}
	public BigDecimal getR0430_total_loan_outstanding_nonresi() {
		return r0430_total_loan_outstanding_nonresi;
	}
	public void setR0430_total_loan_outstanding_nonresi(BigDecimal r0430_total_loan_outstanding_nonresi) {
		this.r0430_total_loan_outstanding_nonresi = r0430_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0430_total_interest_income_nonresi() {
		return r0430_total_interest_income_nonresi;
	}
	public void setR0430_total_interest_income_nonresi(BigDecimal r0430_total_interest_income_nonresi) {
		this.r0430_total_interest_income_nonresi = r0430_total_interest_income_nonresi;
	}
	public String getR0440_loantype() {
		return r0440_loantype;
	}
	public void setR0440_loantype(String r0440_loantype) {
		this.r0440_loantype = r0440_loantype;
	}
	public BigDecimal getR0440_new_loan_in_month_resi() {
		return r0440_new_loan_in_month_resi;
	}
	public void setR0440_new_loan_in_month_resi(BigDecimal r0440_new_loan_in_month_resi) {
		this.r0440_new_loan_in_month_resi = r0440_new_loan_in_month_resi;
	}
	public BigDecimal getR0440_min_interest_rate_resi() {
		return r0440_min_interest_rate_resi;
	}
	public void setR0440_min_interest_rate_resi(BigDecimal r0440_min_interest_rate_resi) {
		this.r0440_min_interest_rate_resi = r0440_min_interest_rate_resi;
	}
	public BigDecimal getR0440_max_interest_rate_resi() {
		return r0440_max_interest_rate_resi;
	}
	public void setR0440_max_interest_rate_resi(BigDecimal r0440_max_interest_rate_resi) {
		this.r0440_max_interest_rate_resi = r0440_max_interest_rate_resi;
	}
	public BigDecimal getR0440_weighted_interest_resi() {
		return r0440_weighted_interest_resi;
	}
	public void setR0440_weighted_interest_resi(BigDecimal r0440_weighted_interest_resi) {
		this.r0440_weighted_interest_resi = r0440_weighted_interest_resi;
	}
	public BigDecimal getR0440_total_loan_outstanding_resi() {
		return r0440_total_loan_outstanding_resi;
	}
	public void setR0440_total_loan_outstanding_resi(BigDecimal r0440_total_loan_outstanding_resi) {
		this.r0440_total_loan_outstanding_resi = r0440_total_loan_outstanding_resi;
	}
	public BigDecimal getR0440_total_interest_income_resi() {
		return r0440_total_interest_income_resi;
	}
	public void setR0440_total_interest_income_resi(BigDecimal r0440_total_interest_income_resi) {
		this.r0440_total_interest_income_resi = r0440_total_interest_income_resi;
	}
	public BigDecimal getR0440_new_loan_in_month_nonresi() {
		return r0440_new_loan_in_month_nonresi;
	}
	public void setR0440_new_loan_in_month_nonresi(BigDecimal r0440_new_loan_in_month_nonresi) {
		this.r0440_new_loan_in_month_nonresi = r0440_new_loan_in_month_nonresi;
	}
	public BigDecimal getR0440_min_interest_rate_nonresi() {
		return r0440_min_interest_rate_nonresi;
	}
	public void setR0440_min_interest_rate_nonresi(BigDecimal r0440_min_interest_rate_nonresi) {
		this.r0440_min_interest_rate_nonresi = r0440_min_interest_rate_nonresi;
	}
	public BigDecimal getR0440_max_interest_rate_nonresi() {
		return r0440_max_interest_rate_nonresi;
	}
	public void setR0440_max_interest_rate_nonresi(BigDecimal r0440_max_interest_rate_nonresi) {
		this.r0440_max_interest_rate_nonresi = r0440_max_interest_rate_nonresi;
	}
	public BigDecimal getR0440_weighted_interest_nonresi() {
		return r0440_weighted_interest_nonresi;
	}
	public void setR0440_weighted_interest_nonresi(BigDecimal r0440_weighted_interest_nonresi) {
		this.r0440_weighted_interest_nonresi = r0440_weighted_interest_nonresi;
	}
	public BigDecimal getR0440_total_loan_outstanding_nonresi() {
		return r0440_total_loan_outstanding_nonresi;
	}
	public void setR0440_total_loan_outstanding_nonresi(BigDecimal r0440_total_loan_outstanding_nonresi) {
		this.r0440_total_loan_outstanding_nonresi = r0440_total_loan_outstanding_nonresi;
	}
	public BigDecimal getR0440_total_interest_income_nonresi() {
		return r0440_total_interest_income_nonresi;
	}
	public void setR0440_total_interest_income_nonresi(BigDecimal r0440_total_interest_income_nonresi) {
		this.r0440_total_interest_income_nonresi = r0440_total_interest_income_nonresi;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getReport_version() {
		return report_version;
	}
	public void setReport_version(String report_version) {
		this.report_version = report_version;
	}
	public String getReport_frequency() {
		return report_frequency;
	}
	public void setReport_frequency(String report_frequency) {
		this.report_frequency = report_frequency;
	}
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public String getReport_desc() {
		return report_desc;
	}
	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	
	
	
	
	public CBUAE_BRF2_14_Summary_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}