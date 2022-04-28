package com.test.app.controller.favorite;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.favorite.FavoriteVO;
import com.test.app.favorite.impl.FavoriteDAO;

@Controller
public class FavoriteController {
	
	@RequestMapping(value="/infav.do")
	public String insert_fav(FavoriteVO vo,FavoriteDAO favoritedao,Model model) {
		//vo=favoritedao.selectOne(vo);
		//if(vo.getSpk()가 없는 spk라면) {
		favoritedao.insert_favorite(vo);
		//}
		
		return "main.do";
	}
	
	@RequestMapping(value="/delfav.do")
	public String delete_fav(FavoriteVO vo,FavoriteDAO favoritedao,HttpSession session) {
		System.out.println("로그 : FAVORITECONTROLLER : 즐겨찾기 삭제 fpk ="+vo.getFpk() +" vo " +vo);
		favoritedao.delete_favorite(vo);
		System.out.println("로그 : FAVORITECONTROLLER : 즐겨찾기 삭제 완료 mid ="+vo.getMid()+" vo " +vo);
		return "main.do";
	}
	
}
