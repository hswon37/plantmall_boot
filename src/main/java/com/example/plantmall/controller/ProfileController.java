package com.example.plantmall.controller;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.plantmall.domain.Profile;
import com.example.plantmall.domain.User;
import com.example.plantmall.service.AuthService;
import com.example.plantmall.service.ProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileService profileService;

	// 프로필 포함 전체 마이페이지
	@GetMapping
	public String getProfile(Model model, @ModelAttribute("profileForm") ProfileForm profileForm, HttpSession session) {
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		User user = userSession.getUser();
		Profile profile = profileService.getProfileByUserId(user.getUserId());
		// 마이페이지 최초 접속일 경우 프로필 초기 설정
		if (profile == null) {
			System.out.println("new profile create page");
			model.addAttribute("newProfile", true);
			return "profile/ProfileForm";
		}
		// 존재하는 마이페이지 로드
		else {
			System.out.println("user profile page");
			model.addAttribute("profile", profile);
			return "profile/Profile";
		}

	}

	// 프로필 수정 페이지
	@GetMapping("/update")
	public ModelAndView updateProfile(ModelAndView mav, @ModelAttribute("profileForm") ProfileForm profileForm,
			HttpSession session) throws ModelAndViewDefiningException {

		UserSession userSession = (UserSession) session.getAttribute("userSession");
		User user = userSession.getUser();
		System.out.println(user.toString());

		Profile profile = profileService.getProfileByUserId(user.getUserId());
		mav.setViewName("profile/ProfileForm");
		// 프로필 수정
		{
			System.out.println("profile update page");
			mav.addObject("newProfile", false);
		}

		/*
		 * //로그인한 사용자와 접속하려는 프로필 유저와 같은지 확인 //같은 경우
		 * if(user.getUserId().equals(profile.getUserId())) { mav.addObject("loginUser",
		 * true); } //다른 경우 else { mav.addObject("loginUser", false);
		 * 
		 * //프로필유저가 로그인유저를 팔로우했는지 확인 }
		 */
		mav.addObject("profile", profile);
		return mav;
	}

	@PostMapping
	public String submit(@ModelAttribute("profileForm") ProfileForm profileForm,
			@RequestParam("fileUrl") MultipartFile multipartFile, HttpServletRequest request, HttpSession session) {
		
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		Profile profile = profileForm.getProfile();
		profile.setUserId(userSession.getUser().getUserId());
		
		String uploadPath = request.getSession().getServletContext().getRealPath("/").concat("resources");
		String imgUploadPath = uploadPath + File.separator + "userProfile"; // 이미지를 업로드할 폴더설정 /uploadPath/imgUpload
		String fileName = null; // 기본 경로와 별개로 작성되는 경로 + 파일이름

		if (multipartFile.getOriginalFilename() != null && !multipartFile.getOriginalFilename().equals("")) {
			// 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)
			UUID uid = UUID.randomUUID();
			fileName = uid + "_" + multipartFile.getOriginalFilename();

			// gdsImg에 원본 파일 경로 + 파일명 저장
			profile.setProfileImg(imgUploadPath + File.separator + fileName);
			
			System.out.println("request={} " + request);
			System.out.println("profileInfo={} " + profileForm.getProfile().toString());
			System.out.println("multipartFile={} " + multipartFile);
			System.out.println("fileName : " + fileName);
			profileService.createProfile(profile);

		}
		return "profile/Profile";
	}

	// 프로필수정페이지 이동
	@RequestMapping("/update")
	public String updateProfile() {
		return "/update";
	}

	// 피드추가버튼. 후에 FeedController로 이동
	@RequestMapping("/upload")
	public String feedUpload() {
		return "FeedUpload";
	}

	// 피드 클릭. 후에 FeedController로 이동
	@RequestMapping("/feed")
	public String showFeed() {
		return "Feed";
	}

}