package com.example.springboot2docker.vo;

import com.example.springboot2docker.annotation.RiskKey;

/**
 * Created with IntelliJ IDEA.
 * User: yujianfu (mr.vencnet@gmail.com)
 * Date: 2018/8/22
 * Time: 上午9:45
 */
public class VariableContact {


    /**
     * 是否认证
     */
    @RiskKey(key = "loc_triple_contact_is_approve")
    private Integer isApprove;
    /**
     * 通讯录条数
     */
    @RiskKey(key = "loc_triple_contact_num")
    private Integer num;
    /**
     * 呼叫号码数
     */
    private Integer callPhoneNum;
    /**
     * 被叫号码数
     */
    private Integer calledPhoneNum;
    /**
     * 主叫号码数
     */
    private Integer callingPhoneNum;
    /**
     * 既有主叫又有被叫号码数
     */
    private Integer callingCalledPhoneNum;
    /**
     * 通讯录异常个数
     */
    private Integer riskNum;
    /**
     * 通讯录命中借贷宝次数
     */
    @RiskKey(key = "loc_triple_contact_hit_jdb_num")
    private Integer hitJdbNum;
    /**
     * 第一联系人是否在通讯录中
     */
    @RiskKey(keys = {"loc_loc_triple_contact_have_first_emergent", "loc_triple_contact_have_first_emergent_gsd"})
    private Integer firstEmergentIsContact;
    /**
     * 第一联系人排名
     */
    private Integer firstEmergentRank;
    /**
     * 第一联系人呼叫次数
     */
    private Integer firstEmergentCallNum;
    /**
     * 第二联系人是否在通讯录中
     */
    @RiskKey(keys = {"loc_triple_contact_have_second_emergent", "loc_triple_contact_have_second_emergent_gsd"})
    private Integer secondEmergentIsContact;
    /**
     * 第二联系人排名
     */
    private Integer secondEmergentRank;
    /**
     * 第二联系人呼叫次数
     */
    private Integer secondEmergentCallNum;
    /**
     * top10联系人不在通讯录个数  -1 代表 代表通话记录为0(不作比较)
     */
    private Integer topTenIsNotContactNum;
    /**
     * 有通话记录的通讯录个数
     */
    private Integer haveCallNum;
    /**
     * 第一联系人关系
     */
    private String firstEmergentRelation;
    /**
     * 通讯录订单通过数
     */
    private Integer contactPassBorrowNum;
    /**
     * 通讯录逾期订单数
     */
    private Integer contactOverdueBorrowNum;
    /**
     * 通讯录拒绝订单数
     */
    private Integer contactRejectBorrowNum;
    /**
     * 通讯录只拒绝订单数
     */
    @RiskKey(key = "loc_triple_contact_only_reject_borrow_num")
    private Integer contactOnlyRejectBorrowNum;
    /**
     * 通话记录通过订单数
     */
    private Integer contactCallPassBorrowNum;
    /**
     * 通话记录逾期订单数
     */
    private Integer contactCallOverdueBorrowNum;
    /**
     * 通话记录只拒绝订单数
     */
    private Integer contactCallOnlyRejectBorrowNum;
    /**
     * 通话记录拒绝订单数
     */
    @RiskKey(key = "loc_triple_contact_call_reject_borrow_num")
    private Integer contactCallRejectBorrowNum;
    /**
     *
     */
    private Integer isDeleted;
    /**
     *
     */
    private Integer applyHitContact;
    /**
     *
     */
    private String applyHitContactName;
    /**
     *
     */
    private Integer applyHitCall;

    @RiskKey(key = "loc_triple_contact_relative_num")
    private Integer relativeNum = 0;//亲戚数

    @RiskKey(key = "loc_triple_contact_high_frequency_in_address_book", isInteger = true)
    private Boolean highFrequencyContactInAddressBook = true;// 设备通话记录高频联系人是否在设备通讯录中

    public Integer getRelativeNum() {
        return relativeNum;
    }

    public VariableContact setRelativeNum(Integer relativeNum) {
        this.relativeNum = relativeNum;
        return this;
    }

    public boolean isHighFrequencyContactInAddressBook() {
        return highFrequencyContactInAddressBook;
    }

    public VariableContact setHighFrequencyContactInAddressBook(boolean highFrequencyContactInAddressBook) {
        this.highFrequencyContactInAddressBook = highFrequencyContactInAddressBook;
        return this;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public VariableContact setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
        return this;
    }

    public Integer getNum() {
        return num;
    }

    public VariableContact setNum(Integer num) {
        this.num = num;
        return this;
    }

    public Integer getCallPhoneNum() {
        return callPhoneNum;
    }

    public VariableContact setCallPhoneNum(Integer callPhoneNum) {
        this.callPhoneNum = callPhoneNum;
        return this;
    }

    public Integer getCalledPhoneNum() {
        return calledPhoneNum;
    }

    public VariableContact setCalledPhoneNum(Integer calledPhoneNum) {
        this.calledPhoneNum = calledPhoneNum;
        return this;
    }

    public Integer getCallingPhoneNum() {
        return callingPhoneNum;
    }

    public VariableContact setCallingPhoneNum(Integer callingPhoneNum) {
        this.callingPhoneNum = callingPhoneNum;
        return this;
    }

    public Integer getCallingCalledPhoneNum() {
        return callingCalledPhoneNum;
    }

    public VariableContact setCallingCalledPhoneNum(Integer callingCalledPhoneNum) {
        this.callingCalledPhoneNum = callingCalledPhoneNum;
        return this;
    }

    public Integer getRiskNum() {
        return riskNum;
    }

    public VariableContact setRiskNum(Integer riskNum) {
        this.riskNum = riskNum;
        return this;
    }

    public Integer getHitJdbNum() {
        return hitJdbNum;
    }

    public VariableContact setHitJdbNum(Integer hitJdbNum) {
        this.hitJdbNum = hitJdbNum;
        return this;
    }

    public Integer getFirstEmergentIsContact() {
        return firstEmergentIsContact;
    }

    public VariableContact setFirstEmergentIsContact(Integer firstEmergentIsContact) {
        this.firstEmergentIsContact = firstEmergentIsContact;
        return this;
    }

    public Integer getFirstEmergentRank() {
        return firstEmergentRank;
    }

    public VariableContact setFirstEmergentRank(Integer firstEmergentRank) {
        this.firstEmergentRank = firstEmergentRank;
        return this;
    }

    public Integer getFirstEmergentCallNum() {
        return firstEmergentCallNum;
    }

    public VariableContact setFirstEmergentCallNum(Integer firstEmergentCallNum) {
        this.firstEmergentCallNum = firstEmergentCallNum;
        return this;
    }

    public Integer getSecondEmergentIsContact() {
        return secondEmergentIsContact;
    }

    public VariableContact setSecondEmergentIsContact(Integer secondEmergentIsContact) {
        this.secondEmergentIsContact = secondEmergentIsContact;
        return this;
    }

    public Integer getSecondEmergentRank() {
        return secondEmergentRank;
    }

    public VariableContact setSecondEmergentRank(Integer secondEmergentRank) {
        this.secondEmergentRank = secondEmergentRank;
        return this;
    }

    public Integer getSecondEmergentCallNum() {
        return secondEmergentCallNum;
    }

    public VariableContact setSecondEmergentCallNum(Integer secondEmergentCallNum) {
        this.secondEmergentCallNum = secondEmergentCallNum;
        return this;
    }

    public Integer getTopTenIsNotContactNum() {
        return topTenIsNotContactNum;
    }

    public VariableContact setTopTenIsNotContactNum(Integer topTenIsNotContactNum) {
        this.topTenIsNotContactNum = topTenIsNotContactNum;
        return this;
    }

    public Integer getHaveCallNum() {
        return haveCallNum;
    }

    public VariableContact setHaveCallNum(Integer haveCallNum) {
        this.haveCallNum = haveCallNum;
        return this;
    }

    public String getFirstEmergentRelation() {
        return firstEmergentRelation;
    }

    public VariableContact setFirstEmergentRelation(String firstEmergentRelation) {
        this.firstEmergentRelation = firstEmergentRelation;
        return this;
    }

    public Integer getContactPassBorrowNum() {
        return contactPassBorrowNum;
    }

    public VariableContact setContactPassBorrowNum(Integer contactPassBorrowNum) {
        this.contactPassBorrowNum = contactPassBorrowNum;
        return this;
    }

    public Integer getContactOverdueBorrowNum() {
        return contactOverdueBorrowNum;
    }

    public VariableContact setContactOverdueBorrowNum(Integer contactOverdueBorrowNum) {
        this.contactOverdueBorrowNum = contactOverdueBorrowNum;
        return this;
    }

    public Integer getContactRejectBorrowNum() {
        return contactRejectBorrowNum;
    }

    public VariableContact setContactRejectBorrowNum(Integer contactRejectBorrowNum) {
        this.contactRejectBorrowNum = contactRejectBorrowNum;
        return this;
    }

    public Integer getContactOnlyRejectBorrowNum() {
        return contactOnlyRejectBorrowNum;
    }

    public VariableContact setContactOnlyRejectBorrowNum(Integer contactOnlyRejectBorrowNum) {
        this.contactOnlyRejectBorrowNum = contactOnlyRejectBorrowNum;
        return this;
    }

    public Integer getContactCallPassBorrowNum() {
        return contactCallPassBorrowNum;
    }

    public VariableContact setContactCallPassBorrowNum(Integer contactCallPassBorrowNum) {
        this.contactCallPassBorrowNum = contactCallPassBorrowNum;
        return this;
    }

    public Integer getContactCallOverdueBorrowNum() {
        return contactCallOverdueBorrowNum;
    }

    public VariableContact setContactCallOverdueBorrowNum(Integer contactCallOverdueBorrowNum) {
        this.contactCallOverdueBorrowNum = contactCallOverdueBorrowNum;
        return this;
    }

    public Integer getContactCallOnlyRejectBorrowNum() {
        return contactCallOnlyRejectBorrowNum;
    }

    public VariableContact setContactCallOnlyRejectBorrowNum(Integer contactCallOnlyRejectBorrowNum) {
        this.contactCallOnlyRejectBorrowNum = contactCallOnlyRejectBorrowNum;
        return this;
    }

    public Integer getContactCallRejectBorrowNum() {
        return contactCallRejectBorrowNum;
    }

    public VariableContact setContactCallRejectBorrowNum(Integer contactCallRejectBorrowNum) {
        this.contactCallRejectBorrowNum = contactCallRejectBorrowNum;
        return this;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public VariableContact setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    public Integer getApplyHitContact() {
        return applyHitContact;
    }

    public VariableContact setApplyHitContact(Integer applyHitContact) {
        this.applyHitContact = applyHitContact;
        return this;
    }

    public String getApplyHitContactName() {
        return applyHitContactName;
    }

    public VariableContact setApplyHitContactName(String applyHitContactName) {
        this.applyHitContactName = applyHitContactName;
        return this;
    }

    public Integer getApplyHitCall() {
        return applyHitCall;
    }

    public VariableContact setApplyHitCall(Integer applyHitCall) {
        this.applyHitCall = applyHitCall;
        return this;
    }
}
