package com.kh.lotto.model.vo;

import java.time.LocalDateTime;
import java.util.HashSet;

public class BlockedUser extends User{
    private LocalDateTime blockedDate;
    private String blockedReason;

    public BlockedUser() {
		// TODO Auto-generated constructor stub
	}
    
	public LocalDateTime getBlockedDate() { return blockedDate; }
	public void setBlockedDate(LocalDateTime blockedDate) { this.blockedDate = blockedDate; }
	public String getBlockedReason() { return blockedReason; }
	public void setBlockedReason(String blockedReason) { this.blockedReason = blockedReason; }
}
