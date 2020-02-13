/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

/**
 *
 * @author quanhaonan
 */
public class RoleCreate {
        public static Role createRole(Role.RoleType type) {
        if(type.equals(Role.RoleType.Staff)) {
            return new StaffRole();
        }
        if (type.equals(Role.RoleType.Manager)) {
            return new ManagerRole();
        }
        if(type.equals(Role.RoleType.Boss)) {
            return new BossRole();
        }
        if(type.equals(Role.RoleType.SystemManager)) {
            return new SystemAdminRole();
        }
        return null;
    }
}
