package com.example.sessionEx.service;
import com.example.sessionEx.dao.MainDAO;
import com.example.sessionEx.vo.IpBanVO;
import com.example.sessionEx.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainDAO mainDAO;

    public UserVO getUser(UserVO userVo){
        return mainDAO.getUser(userVo);
    }

    public List<IpBanVO> getIpBanList(){
        return mainDAO.getIpBanList();
    }

}
