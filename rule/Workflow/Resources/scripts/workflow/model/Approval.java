package workflow.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import kz.lof.dataengine.jpa.SecureAppEntity;

@Entity
@Table(name = "approvals")
@NamedQuery(name = "Approval.findAll", query = "SELECT m FROM Approval AS m ORDER BY m.regDate")
public class Approval extends SecureAppEntity {

}
