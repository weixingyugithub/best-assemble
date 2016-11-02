package com.beijing.wei.login.model;

import com.beijing.wei.util.file.generatorMybatis.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectUserAllExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public ProjectUserAllExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserAllIdIsNull() {
            addCriterion("user_all_id is null");
            return (Criteria) this;
        }

        public Criteria andUserAllIdIsNotNull() {
            addCriterion("user_all_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllIdEqualTo(String value) {
            addCriterion("user_all_id =", value, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdNotEqualTo(String value) {
            addCriterion("user_all_id <>", value, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdGreaterThan(String value) {
            addCriterion("user_all_id >", value, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_id >=", value, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdLessThan(String value) {
            addCriterion("user_all_id <", value, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdLessThanOrEqualTo(String value) {
            addCriterion("user_all_id <=", value, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdLike(String value) {
            addCriterion("user_all_id like", value, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdNotLike(String value) {
            addCriterion("user_all_id not like", value, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdIn(List<String> values) {
            addCriterion("user_all_id in", values, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdNotIn(List<String> values) {
            addCriterion("user_all_id not in", values, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdBetween(String value1, String value2) {
            addCriterion("user_all_id between", value1, value2, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllIdNotBetween(String value1, String value2) {
            addCriterion("user_all_id not between", value1, value2, "userAllId");
            return (Criteria) this;
        }

        public Criteria andUserAllNameIsNull() {
            addCriterion("user_all_name is null");
            return (Criteria) this;
        }

        public Criteria andUserAllNameIsNotNull() {
            addCriterion("user_all_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllNameEqualTo(String value) {
            addCriterion("user_all_name =", value, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameNotEqualTo(String value) {
            addCriterion("user_all_name <>", value, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameGreaterThan(String value) {
            addCriterion("user_all_name >", value, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_name >=", value, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameLessThan(String value) {
            addCriterion("user_all_name <", value, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameLessThanOrEqualTo(String value) {
            addCriterion("user_all_name <=", value, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameLike(String value) {
            addCriterion("user_all_name like", value, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameNotLike(String value) {
            addCriterion("user_all_name not like", value, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameIn(List<String> values) {
            addCriterion("user_all_name in", values, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameNotIn(List<String> values) {
            addCriterion("user_all_name not in", values, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameBetween(String value1, String value2) {
            addCriterion("user_all_name between", value1, value2, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllNameNotBetween(String value1, String value2) {
            addCriterion("user_all_name not between", value1, value2, "userAllName");
            return (Criteria) this;
        }

        public Criteria andUserAllPassIsNull() {
            addCriterion("user_all_pass is null");
            return (Criteria) this;
        }

        public Criteria andUserAllPassIsNotNull() {
            addCriterion("user_all_pass is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllPassEqualTo(String value) {
            addCriterion("user_all_pass =", value, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassNotEqualTo(String value) {
            addCriterion("user_all_pass <>", value, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassGreaterThan(String value) {
            addCriterion("user_all_pass >", value, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_pass >=", value, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassLessThan(String value) {
            addCriterion("user_all_pass <", value, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassLessThanOrEqualTo(String value) {
            addCriterion("user_all_pass <=", value, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassLike(String value) {
            addCriterion("user_all_pass like", value, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassNotLike(String value) {
            addCriterion("user_all_pass not like", value, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassIn(List<String> values) {
            addCriterion("user_all_pass in", values, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassNotIn(List<String> values) {
            addCriterion("user_all_pass not in", values, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassBetween(String value1, String value2) {
            addCriterion("user_all_pass between", value1, value2, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllPassNotBetween(String value1, String value2) {
            addCriterion("user_all_pass not between", value1, value2, "userAllPass");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameIsNull() {
            addCriterion("user_all_surname is null");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameIsNotNull() {
            addCriterion("user_all_surname is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameEqualTo(String value) {
            addCriterion("user_all_surname =", value, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameNotEqualTo(String value) {
            addCriterion("user_all_surname <>", value, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameGreaterThan(String value) {
            addCriterion("user_all_surname >", value, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_surname >=", value, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameLessThan(String value) {
            addCriterion("user_all_surname <", value, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameLessThanOrEqualTo(String value) {
            addCriterion("user_all_surname <=", value, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameLike(String value) {
            addCriterion("user_all_surname like", value, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameNotLike(String value) {
            addCriterion("user_all_surname not like", value, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameIn(List<String> values) {
            addCriterion("user_all_surname in", values, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameNotIn(List<String> values) {
            addCriterion("user_all_surname not in", values, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameBetween(String value1, String value2) {
            addCriterion("user_all_surname between", value1, value2, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllSurnameNotBetween(String value1, String value2) {
            addCriterion("user_all_surname not between", value1, value2, "userAllSurname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameIsNull() {
            addCriterion("user_all_firstname is null");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameIsNotNull() {
            addCriterion("user_all_firstname is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameEqualTo(String value) {
            addCriterion("user_all_firstname =", value, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameNotEqualTo(String value) {
            addCriterion("user_all_firstname <>", value, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameGreaterThan(String value) {
            addCriterion("user_all_firstname >", value, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_firstname >=", value, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameLessThan(String value) {
            addCriterion("user_all_firstname <", value, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameLessThanOrEqualTo(String value) {
            addCriterion("user_all_firstname <=", value, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameLike(String value) {
            addCriterion("user_all_firstname like", value, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameNotLike(String value) {
            addCriterion("user_all_firstname not like", value, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameIn(List<String> values) {
            addCriterion("user_all_firstname in", values, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameNotIn(List<String> values) {
            addCriterion("user_all_firstname not in", values, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameBetween(String value1, String value2) {
            addCriterion("user_all_firstname between", value1, value2, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllFirstnameNotBetween(String value1, String value2) {
            addCriterion("user_all_firstname not between", value1, value2, "userAllFirstname");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationIsNull() {
            addCriterion("user_all_compellation is null");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationIsNotNull() {
            addCriterion("user_all_compellation is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationEqualTo(String value) {
            addCriterion("user_all_compellation =", value, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationNotEqualTo(String value) {
            addCriterion("user_all_compellation <>", value, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationGreaterThan(String value) {
            addCriterion("user_all_compellation >", value, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_compellation >=", value, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationLessThan(String value) {
            addCriterion("user_all_compellation <", value, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationLessThanOrEqualTo(String value) {
            addCriterion("user_all_compellation <=", value, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationLike(String value) {
            addCriterion("user_all_compellation like", value, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationNotLike(String value) {
            addCriterion("user_all_compellation not like", value, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationIn(List<String> values) {
            addCriterion("user_all_compellation in", values, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationNotIn(List<String> values) {
            addCriterion("user_all_compellation not in", values, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationBetween(String value1, String value2) {
            addCriterion("user_all_compellation between", value1, value2, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllCompellationNotBetween(String value1, String value2) {
            addCriterion("user_all_compellation not between", value1, value2, "userAllCompellation");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayIsNull() {
            addCriterion("user_all_birthday is null");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayIsNotNull() {
            addCriterion("user_all_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayEqualTo(Date value) {
            addCriterion("user_all_birthday =", value, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayNotEqualTo(Date value) {
            addCriterion("user_all_birthday <>", value, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayGreaterThan(Date value) {
            addCriterion("user_all_birthday >", value, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("user_all_birthday >=", value, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayLessThan(Date value) {
            addCriterion("user_all_birthday <", value, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("user_all_birthday <=", value, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayIn(List<Date> values) {
            addCriterion("user_all_birthday in", values, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayNotIn(List<Date> values) {
            addCriterion("user_all_birthday not in", values, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayBetween(Date value1, Date value2) {
            addCriterion("user_all_birthday between", value1, value2, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("user_all_birthday not between", value1, value2, "userAllBirthday");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailIsNull() {
            addCriterion("user_all_email is null");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailIsNotNull() {
            addCriterion("user_all_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailEqualTo(String value) {
            addCriterion("user_all_email =", value, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailNotEqualTo(String value) {
            addCriterion("user_all_email <>", value, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailGreaterThan(String value) {
            addCriterion("user_all_email >", value, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_email >=", value, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailLessThan(String value) {
            addCriterion("user_all_email <", value, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailLessThanOrEqualTo(String value) {
            addCriterion("user_all_email <=", value, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailLike(String value) {
            addCriterion("user_all_email like", value, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailNotLike(String value) {
            addCriterion("user_all_email not like", value, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailIn(List<String> values) {
            addCriterion("user_all_email in", values, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailNotIn(List<String> values) {
            addCriterion("user_all_email not in", values, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailBetween(String value1, String value2) {
            addCriterion("user_all_email between", value1, value2, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllEmailNotBetween(String value1, String value2) {
            addCriterion("user_all_email not between", value1, value2, "userAllEmail");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneIsNull() {
            addCriterion("user_all_phone is null");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneIsNotNull() {
            addCriterion("user_all_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneEqualTo(String value) {
            addCriterion("user_all_phone =", value, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneNotEqualTo(String value) {
            addCriterion("user_all_phone <>", value, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneGreaterThan(String value) {
            addCriterion("user_all_phone >", value, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_phone >=", value, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneLessThan(String value) {
            addCriterion("user_all_phone <", value, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_all_phone <=", value, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneLike(String value) {
            addCriterion("user_all_phone like", value, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneNotLike(String value) {
            addCriterion("user_all_phone not like", value, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneIn(List<String> values) {
            addCriterion("user_all_phone in", values, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneNotIn(List<String> values) {
            addCriterion("user_all_phone not in", values, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneBetween(String value1, String value2) {
            addCriterion("user_all_phone between", value1, value2, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllPhoneNotBetween(String value1, String value2) {
            addCriterion("user_all_phone not between", value1, value2, "userAllPhone");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeIsNull() {
            addCriterion("user_all_native is null");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeIsNotNull() {
            addCriterion("user_all_native is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeEqualTo(String value) {
            addCriterion("user_all_native =", value, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeNotEqualTo(String value) {
            addCriterion("user_all_native <>", value, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeGreaterThan(String value) {
            addCriterion("user_all_native >", value, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_native >=", value, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeLessThan(String value) {
            addCriterion("user_all_native <", value, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeLessThanOrEqualTo(String value) {
            addCriterion("user_all_native <=", value, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeLike(String value) {
            addCriterion("user_all_native like", value, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeNotLike(String value) {
            addCriterion("user_all_native not like", value, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeIn(List<String> values) {
            addCriterion("user_all_native in", values, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeNotIn(List<String> values) {
            addCriterion("user_all_native not in", values, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeBetween(String value1, String value2) {
            addCriterion("user_all_native between", value1, value2, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllNativeNotBetween(String value1, String value2) {
            addCriterion("user_all_native not between", value1, value2, "userAllNative");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceIsNull() {
            addCriterion("user_all_province is null");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceIsNotNull() {
            addCriterion("user_all_province is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceEqualTo(String value) {
            addCriterion("user_all_province =", value, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceNotEqualTo(String value) {
            addCriterion("user_all_province <>", value, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceGreaterThan(String value) {
            addCriterion("user_all_province >", value, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_province >=", value, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceLessThan(String value) {
            addCriterion("user_all_province <", value, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceLessThanOrEqualTo(String value) {
            addCriterion("user_all_province <=", value, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceLike(String value) {
            addCriterion("user_all_province like", value, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceNotLike(String value) {
            addCriterion("user_all_province not like", value, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceIn(List<String> values) {
            addCriterion("user_all_province in", values, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceNotIn(List<String> values) {
            addCriterion("user_all_province not in", values, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceBetween(String value1, String value2) {
            addCriterion("user_all_province between", value1, value2, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllProvinceNotBetween(String value1, String value2) {
            addCriterion("user_all_province not between", value1, value2, "userAllProvince");
            return (Criteria) this;
        }

        public Criteria andUserAllCityIsNull() {
            addCriterion("user_all_city is null");
            return (Criteria) this;
        }

        public Criteria andUserAllCityIsNotNull() {
            addCriterion("user_all_city is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllCityEqualTo(String value) {
            addCriterion("user_all_city =", value, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityNotEqualTo(String value) {
            addCriterion("user_all_city <>", value, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityGreaterThan(String value) {
            addCriterion("user_all_city >", value, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_city >=", value, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityLessThan(String value) {
            addCriterion("user_all_city <", value, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityLessThanOrEqualTo(String value) {
            addCriterion("user_all_city <=", value, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityLike(String value) {
            addCriterion("user_all_city like", value, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityNotLike(String value) {
            addCriterion("user_all_city not like", value, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityIn(List<String> values) {
            addCriterion("user_all_city in", values, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityNotIn(List<String> values) {
            addCriterion("user_all_city not in", values, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityBetween(String value1, String value2) {
            addCriterion("user_all_city between", value1, value2, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCityNotBetween(String value1, String value2) {
            addCriterion("user_all_city not between", value1, value2, "userAllCity");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyIsNull() {
            addCriterion("user_all_county is null");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyIsNotNull() {
            addCriterion("user_all_county is not null");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyEqualTo(String value) {
            addCriterion("user_all_county =", value, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyNotEqualTo(String value) {
            addCriterion("user_all_county <>", value, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyGreaterThan(String value) {
            addCriterion("user_all_county >", value, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyGreaterThanOrEqualTo(String value) {
            addCriterion("user_all_county >=", value, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyLessThan(String value) {
            addCriterion("user_all_county <", value, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyLessThanOrEqualTo(String value) {
            addCriterion("user_all_county <=", value, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyLike(String value) {
            addCriterion("user_all_county like", value, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyNotLike(String value) {
            addCriterion("user_all_county not like", value, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyIn(List<String> values) {
            addCriterion("user_all_county in", values, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyNotIn(List<String> values) {
            addCriterion("user_all_county not in", values, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyBetween(String value1, String value2) {
            addCriterion("user_all_county between", value1, value2, "userAllCounty");
            return (Criteria) this;
        }

        public Criteria andUserAllCountyNotBetween(String value1, String value2) {
            addCriterion("user_all_county not between", value1, value2, "userAllCounty");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}