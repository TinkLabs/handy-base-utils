package com.tinklabs.handy.base.util;

import com.tinklabs.handy.base.exception.BaseErrors;
import com.tinklabs.handy.base.vo.ResultVO;

import java.io.Serializable;

public class ResultUtil implements Serializable {

    public static Boolean isNotNull(ResultVO resultVO){
        if(resultVO == null){
            return false;
        }

        if(!BaseErrors.SUCCESS.getCode().equals(resultVO.getCode())){
            return false;
        }

        if(resultVO.getData() == null){
            return false;
        }
        return true;
    }

    public static Boolean isNull(ResultVO resultVO){
       return !isNotNull(resultVO);
    }
}
