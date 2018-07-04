/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yousif Mubareka
 */
public enum Role {

    READER(true, false, false, false, false, false, false, false, false),
    EDITOR(true, true, true, false, false, true, true, false, false),
    ADMIN(true, true, true, true, true, true, true, false, false),
    SUPERADMIN(true, true, true, true, true, true, true, true, true);

    private final boolean readArticle;
    private final boolean writeArticle;
    private final boolean deleteArticle;
    private final boolean addCategory;
    private final boolean deleteCategory;
    private final boolean addTopic;
    private final boolean deleteTopic;
    private final boolean deleteUser;
    private final boolean addUser;

    private Role(boolean readArticle, boolean writeArticle, boolean deleteArticle, boolean addCategory, boolean deleteCategory, boolean addTopic, boolean deleteTopic, boolean deleteUser, boolean addUser) {

        this.readArticle = readArticle;
        this.writeArticle = writeArticle;
        this.deleteArticle = deleteArticle;
        this.addCategory = addCategory;
        this.deleteCategory = deleteCategory;
        this.addTopic = addTopic;
        this.deleteTopic = deleteTopic;
        this.deleteUser = deleteUser;
        this.addUser = addUser;

    }

    /**
     * @return the readArticle
     */
    public boolean isReadArticle() {
        return readArticle;
    }

    /**
     * @return the writeArticle
     */
    public boolean isWriteArticle() {
        return writeArticle;
    }

    /**
     * @return the deleteArticle
     */
    public boolean isDeleteArticle() {
        return deleteArticle;
    }

    /**
     * @return the addCategory
     */
    public boolean isAddCategory() {
        return addCategory;
    }

    /**
     * @return the deleteCategory
     */
    public boolean isDeleteCategory() {
        return deleteCategory;
    }

    /**
     * @return the addTopic
     */
    public boolean isAddTopic() {
        return addTopic;
    }

    /**
     * @return the deleteTopic
     */
    public boolean isDeleteTopic() {
        return deleteTopic;
    }

    /**
     * @return the deleteUser
     */
    public boolean isDeleteUser() {
        return deleteUser;
    }

    /**
     * @return the addUser
     */
    public boolean isAddUser() {
        return addUser;
    }

    public List<String> showPermissions() {
        List<String> permissions = new ArrayList<>();
        for (Field field : Role.class.getDeclaredFields()) {
            if (Modifier.isPrivate(field.getModifiers()) && !Modifier.isStatic((field.getModifiers()))) {
                try {
                    permissions.add(field.getName()+":"+field.get(this));               
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(Role.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return permissions;
    }

}
