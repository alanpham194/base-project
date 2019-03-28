/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commons.client.response;

/**
 *
 * @author Admin
 */
public class LockResponse {

    private boolean success;
    private String description;

    public LockResponse(boolean status, String description) {
        this.success = status;
        this.description = description;
    }

    public LockResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
