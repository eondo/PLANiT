package com.project.planit.storage.service;

import com.project.planit.common.exception.NotFoundException;
import com.project.planit.member.entity.Member;
import com.project.planit.member.repository.MemberRepository;
import com.project.planit.room.entity.Room;
import com.project.planit.room.repository.RoomRepository;
import com.project.planit.storage.dto.CreateStorageRequest;
import com.project.planit.storage.dto.UpdateStorageRequest;
import com.project.planit.storage.entity.Storage;
import com.project.planit.storage.repository.StorageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * packageName    : com.project.planit.storage.service fileName       : StorageServiceImpl author
 *      : SSAFY date           : 2023-01-31 description    :
 * =========================================================== DATE              AUTHOR
 * NOTE ----------------------------------------------------------- 2023-01-31        SSAFY       최초
 * 생성
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService{
  private final StorageRepository storageRepository;
  private final MemberRepository memberRepository;
  private final RoomRepository roomRepository;
  @Override
  @Transactional
  public void createStorage(CreateStorageRequest request,Long id) {
    Member member=memberRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(NotFoundException.USER_NOT_FOUND));

    Room room=roomRepository.findById(request.getRoomId())
        .orElseThrow(() -> new NotFoundException(NotFoundException.ROOM_NOT_FOUND));

    storageRepository.save(Storage.create(request,member,room));
  }

  @Override
  @Transactional
  public void updateStorage(UpdateStorageRequest request,Long memberId) {
      Member member=memberRepository.findById(memberId)
          .orElseThrow(() -> new NotFoundException(NotFoundException.ROOM_NOT_FOUND));

      Storage storage=storageRepository.findById(request.getRoomId())
          .orElseThrow(() -> new NotFoundException(NotFoundException.ROOM_NOT_FOUND));

      storage.update(request,member);
  }

  @Override
  public List<Storage> findStorageList(Long roomId) {
      // @TODO : 아이디 토큰 값으로 변경
      Member member=memberRepository.findById(1L)
          .orElseThrow(() -> new NotFoundException(NotFoundException.USER_NOT_FOUND));

      Room room=roomRepository.findById(roomId)
          .orElseThrow(() -> new NotFoundException(NotFoundException.ROOM_NOT_FOUND));

      return storageRepository.findAllByMemberAndRoom(member,room);
  }
}
