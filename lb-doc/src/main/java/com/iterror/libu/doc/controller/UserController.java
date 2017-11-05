package com.iterror.libu.doc.controller;

import com.iterror.libu.common.bto.ResultBTO;
import com.iterror.libu.common.view.BaseController;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tony.yan on 2017/10/30.
 */
public class UserController extends BaseController {

    public ResultBTO userLogin(@RequestParam(value = "name") String name, @RequestParam(value = "pwd") String pwd) {
        return null;
    }
}
