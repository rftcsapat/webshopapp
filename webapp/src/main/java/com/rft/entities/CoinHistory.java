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
	private long coinhistoryid;
	
	@Column(nullable=false)
	private long userid;
	
	@Column(nullable=false)
	private long price;
	
	@Column(nullable=false)
	private long coins;
	
	@Column(nullable=false, length=10)
	private long changedate;

	public long getCoinhistoryid() {
		return coinhistoryid;
	}

	public void setCoinhistoryid(long coinhistoryid) {
		this.coinhistoryid = coinhistoryid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getCoins() {
		return coins;
	}

	public void setCoins(long coins) {
		this.coins = coins;
	}

	public long getChangedate() {
		return changedate;
	}

	public void setChangedate(long changedate) {
		this.changedate = changedate;
	}

	public CoinHistory() {
		super();
	}
	
}