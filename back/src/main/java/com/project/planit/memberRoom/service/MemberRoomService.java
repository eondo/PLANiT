package com.project.planit.memberRoom.service;

import com.project.planit.memberRoom.dto.createMemberRoomRequest;
import com.project.planit.memberRoom.entity.MemberRoom;


import java.util.List;

/**
 * packageName    : com.project.planit.memberRoom.service fileName       : MemberRoomService author
 *        : SSAFY date           : 2023-01-30 description    :
 * =========================================================== DATE              AUTHOR
 * NOTE ----------------------------------------------------------- 2023-01-30        SSAFY       최초
 * 생성
 */
public interface MemberRoomService {
  List<MemberRoom> findMemberRoom(Long id);
  void updateMemberRoom();

  void createMemberRoom(createMemberRoomRequest request);

}