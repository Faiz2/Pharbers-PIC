package pha.com.code.topFour.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pha.com.code.topFour.dao.TopFourMapper;
import pha.com.code.topFour.model.TopFour;
import pha.com.code.topFour.service.TopFourService;
import pha.com.common.base.service.impl.BaseServiceImpl;

@Service("TopFourService")
public class TopFourServiceImpl extends BaseServiceImpl<TopFour> implements TopFourService {
	
	@Resource
	private TopFourMapper topFourMapper;
}
