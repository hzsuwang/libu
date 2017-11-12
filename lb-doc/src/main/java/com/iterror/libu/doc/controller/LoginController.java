package com.iterror.libu.doc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iterror.libu.common.bto.ResultBTO;
import com.iterror.libu.common.view.BaseController;

/**
 * Created by tony.yan on 2017/11/5.
 */
@RestController
public class LoginController extends BaseController {

    @RequestMapping(value = "/member/login.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultBTO login() {
        ResultBTO resultBTO = new ResultBTO();
        return resultBTO;
    }

    @RequestMapping(value = "/member/get_vcode.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultBTO getVcode() {
        ResultBTO resultBTO = new ResultBTO();
        return resultBTO;
    }

    @RequestMapping(value = "/member/check_vcode.json", method = RequestMethod.POST)
    @ResponseBody
    public ResultBTO checkVcode() {
        ResultBTO resultBTO = new ResultBTO();
        return resultBTO;
    }

}
