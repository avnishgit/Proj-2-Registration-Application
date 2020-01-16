package com.ag.mode;

import lombok.Data;
/**
 * This class is binding for unlockAccount form
 * @author AVNISH SINGH
 * @version 2.2
 */
@Data
public class UnlockAccount {
	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;

}
