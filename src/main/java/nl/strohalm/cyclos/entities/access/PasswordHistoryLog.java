/*
    This file is part of Cyclos (www.cyclos.org).
    A project of the Social Trade Organisation (www.socialtrade.org).

    Cyclos is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    Cyclos is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Cyclos; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 */
package nl.strohalm.cyclos.entities.access;

import nl.strohalm.cyclos.entities.Entity;
import nl.strohalm.cyclos.utils.StringValuedEnum;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Calendar;

/**
 * Logs a history of previous passwords used, in order to prevent the same password to be used again
 * 
 * @author luis
 */
@Table(name = "password_history")
@javax.persistence.Entity
public class PasswordHistoryLog extends Entity {

    public static enum PasswordType implements StringValuedEnum {
        LOGIN, PIN;

        public String getValue() {
            return name().substring(0, 1);
        }
    }

    private static final long serialVersionUID = 6808724316036132120L;

    @ManyToOne
    @JoinColumn(nullable = false)
	private User              user;

    @Column(nullable = false)
    private Calendar          date;

    @Convert(converter = PasswordTypeAttributeConverter.class)
    @Column(length = 1, nullable = false)
	private PasswordType      type;

    @Column(length = 64, nullable = false)
    private String            password;

    public Calendar getDate() {
        return date;
    }

    public String getPassword() {
        return password;
    }

    public PasswordType getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public void setDate(final Calendar date) {
        this.date = date;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setType(final PasswordType type) {
        this.type = type;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return getId() + " - " + password;
    }

}
