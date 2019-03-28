package commons.utils;

public interface Messages {
    String CAMPAIGN_NOT_FOUND = "Campaign is not found!";
    String UNAUTHOZIRED = "Signature is expired or not available!";
    String REFERRAL_ACITIVY_LOG = "<b>%s</b> reward back after %s's first qualifying booking of <b>%s</b> or more. Paid in AVA rewards.";
    String REFERRAL_DONE_ACITIVY_LOG = "Congratulations you have received a <b>%s</b> reward back in AVA for %s's first qualifying booking.";
    String DONE_AND_LESS_THAN_MINIMUM = "Sorry the first booking of %s did not qualify for rewards as it was less than the required <b>%s</b>.";
    String INVALID_MESSAGE = "Sorry the first booking of %s did not qualify for rewards.";
    String REFERRAL_INVITER_SAME_INVITEE = "Inviter id could not be same as invitee id !";
    String REFERRAL_EXISTED = "Referral this user existed!";
    String REFERRAL_ACITIVY_LOG_EXPIRED = "Your friend %s did not make a qualifying booking of <b>%s</b> or more within the %s day period.";
}
