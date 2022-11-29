package com.soa.specificationexample.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.soa.specificationexample.dto.UserRequestDTO;
import com.soa.specificationexample.model.User;

public class UserSpecification implements Specification<User> {

	private static final long serialVersionUID = -1418612780146044594L;

	private final UserRequestDTO criteria;

	public UserSpecification(UserRequestDTO criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<User> root, CriteriaQuery<?> arg1, CriteriaBuilder criteriaBuilder) {

		List<Predicate> predicates = new ArrayList<>();

		if(StringUtils.hasText(criteria.getFirstname())) {
			predicates.add(criteriaBuilder.equal(root.get("firstname"), criteria.getFirstname()));
		}
		if(StringUtils.hasText(criteria.getLastname())) {
			predicates.add(criteriaBuilder.equal(root.get("year"), criteria.getLastname()));
		}
		if(StringUtils.hasText(criteria.getEmail())) {
			predicates.add(criteriaBuilder.equal(root.get("year"), criteria.getEmail()));
		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	}

}
