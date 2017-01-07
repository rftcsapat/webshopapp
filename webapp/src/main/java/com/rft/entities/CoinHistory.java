package com.rft.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="coinhistory", indexes = {
	@Index(columnList = "coinhistoryid", unique = true)
})
public class CoinHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long coinhistoryid;
	
	@Column(nullable=false)
	private Long userid;
	
	@Column(nullable=true)
	private Long cash;
	
	@Column(nullable=false)
	private Long coins;
	
	@Column(nullable=false, length=10)
	private String changedate;
	
	@Column(nullable=true, length=500)
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCoinhistoryid() {
		return coinhistoryid;
	}

	public void setCoinhistoryid(Long coinhistoryid) {
		this.coinhistoryid = coinhistoryid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getCash() {
		return cash;
	}

	public void setCash(Long cash) {
		this.cash = cash;
	}

	public Long getCoins() {
		return coins;
	}

	public void setCoins(Long coins) {
		this.coins = coins;
	}

	public String getChangedate() {
		return changedate;
	}

	public void setChangedate(String changedate) {
		this.changedate = changedate;
	}

	public CoinHistory() {
		super();
	}
	
}
