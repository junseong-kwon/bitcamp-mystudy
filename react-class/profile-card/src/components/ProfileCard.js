import React, { useState, useEffect } from "react";
import axios from "axios";
import {
  Avatar,
  Card,
  CardContent,
  Typography,
  Badge,
  Chip,
  Dialog,
  DialogContent,
} from "@mui/material";

// 프로필 카드 컴포넌트
function ProfileCard({ seatNumber, name, imgSrc, status, isSelf, openModal }) {
  const isOnline = status === "online" || isSelf;
  const isOffline = status === "offline";
  const showStatus = !isSelf; // 본인에게는 온라인/오프라인 상태 표시 안함

  const [hovered, setHovered] = useState(false); // 이미지 호버 상태 관리

  return (
    <Card
      sx={{
        backgroundColor: isSelf ? "#ffffff" : "#f7f7f7",
        borderRadius: "10px",
        boxShadow: "0 4px 12px rgba(0, 0, 0, 0.1)",
        width: "200px",
        textAlign: "center",
        padding: "0px",
        margin: "0px",
        height: "155px",
      }}
    >
      <CardContent>
        {/* 상단 번호 */}
        <div
          style={{
            display: "flex",
            justifyContent: "space-between",
            backgroundColor: "#f7f7f7",
            alignItems: "center",
            position: "relative",
            padding: "0px 0px",
            marginLeft: "-16px",
            marginRight: "-16px",
            top: "-16px",
            height: "35px",
          }}
        >
          <Typography
            sx={{
              fontSize: "17px",
              fontWeight: "500",
              color: isOnline ? "#333" : "#b0b0b0", // 온라인: 진한 색, 오프라인: 회색
              margin: "10px",
            }}
          >
            No. {seatNumber}
          </Typography>

          {/* 온라인/오프라인 상태 (본인에게는 표시 안함) */}
          {showStatus && (
            <Chip
              label={isOnline ? "온라인" : "오프라인"}
              sx={{
                backgroundColor: isOnline ? "#28a745" : "#b0b0b0", // 온라인: 초록색, 오프라인: 회색
                color: "white",
                fontSize: "14px",
                borderRadius: "12px",
                padding: "0 0px",
                height: "20px",
                marginRight: "10px",
              }}
            />
          )}
        </div>

        {/* 프로필 이미지 및 이해도 표시 */}
        <Badge
          overlap="circle"
          anchorOrigin={{ vertical: "bottom", horizontal: "right" }}
          badgeContent={
            isSelf && (
              <span
                style={{
                  backgroundColor: "#28a745", // 본인에게만 초록색 이해도 표시
                  borderRadius: "50%",
                  width: "8px",
                  height: "8px",
                  display: "inline-block",
                }}
              />
            )
          }
        >
          <Avatar
            sx={{
              marginTop: "5px",
              width: "50px",
              height: "50px",
              filter: isOnline ? "none" : "grayscale(100%)", // 오프라인: 흑백 필터
              transition: "transform 1s ease", // 호버 애니메이션 추가
              transform: hovered ? "scale(1.1)" : "scale(1)", // 호버 시 이미지 확대
              cursor: "pointer", // 클릭 가능한 상태를 나타내는 커서
            }}
            src={imgSrc}
            alt={`${name}'s profile`}
            onMouseEnter={() => setHovered(true)} // 호버 시작
            onMouseLeave={() => setHovered(false)} // 호버 종료
            onClick={() => openModal(name)} // 클릭하면 모달 열기
          />
        </Badge>

        {/* 이름 */}
        <Typography
          sx={{
            marginTop: "8px",
            fontSize: "16px",
            fontWeight: "600",
            color: isOnline ? "#333" : "#b0b0b0", // 온라인: 진한 색, 오프라인: 회색
          }}
          onClick={() => openModal(name)}
        >
          {name}
        </Typography>
      </CardContent>
    </Card>
  );
}

// 메인 컴포넌트
export default function StudentRoom() {
  const [open, setOpen] = useState(false);
  const [currentProfile, setCurrentProfile] = useState({});
  const [profiles, setProfiles] = useState([]);

  // Axios로 서버에서 데이터를 가져오는 함수
  useEffect(() => {
    axios
      .get("http://localhost:8081/api/seat/") // 백엔드 API 요청
      .then((response) => {
        console.log(response.data); // 브라우저 콘솔에서 데이터를 확인
        setProfiles(response.data); // 받아온 데이터를 상태로 저장
      })
      .catch((error) => {
        console.error("데이터를 불러오는 중 오류가 발생했습니다:", error);
      });
  }, []);
  // 모달 열기 함수
  const openProfileModal = (name) => {
    setCurrentProfile({
      name,
      email: "example@example.com",
      github: "https://github.com/username",
      phone: "010-1234-5678",
      message: "카톡 상세 메시지",
    });
    setOpen(true);
  };

  // 모달 닫기 함수
  const closeProfileModal = () => {
    setOpen(false);
  };

  return (
    <div
      style={{
        display: "grid",
        gridTemplateColumns: "repeat(5, 1fr)",
        gap: "20px",
        marginLeft: "250px",
        marginRight: "100px",
      }}
    >
      {profiles.map((profile, index) => (
        <ProfileCard
          key={index}
          seatNumber={profile.seatNumber}
          name={profile.user ? profile.user.name : "빈 좌석"}
          imgSrc={profile.user ? profile.user.profileImage.pictureUrl : ""}
          status={profile.occupied ? "online" : "offline"}
          isSelf={profile.isSelf} // 본인 여부 확인
          openModal={openProfileModal}
        />
      ))}

      {/* 모달 컴포넌트 */}
      <Dialog open={open} onClose={closeProfileModal}>
        <DialogContent
          sx={{
            padding: "30px",
          }}
        >
          <Avatar
            src="https://via.placeholder.com/100"
            alt={`${currentProfile.name}'s profile`}
            style={{ width: "100px", height: "100px", marginLeft: "56px" }}
          />
          <Typography
            sx={{
              fontSize: "12px",
              marginTop: "30px",
            }}
            variant="h6"
          >
            <strong>이름:</strong>
          </Typography>
          <Typography
            sx={{
              borderBottom: "solid 1px",
              borderBottomColor: "darkgray",
            }}
          >
            {currentProfile.name}
          </Typography>
          <Typography
            sx={{
              fontSize: "12px",
            }}
          >
            <strong>이메일:</strong>
          </Typography>
          <Typography
            sx={{
              borderBottom: "solid 1px",
              borderBottomColor: "darkgray",
            }}
          >
            {currentProfile.email}
          </Typography>
          <Typography
            sx={{
              fontSize: "12px",
            }}
          >
            <strong>GitHub:</strong>
            <Typography>
              <a
                href={currentProfile.github}
                target="_blank"
                rel="noopener noreferrer"
              >
                {currentProfile.github}
              </a>
            </Typography>
          </Typography>
          <Typography
            sx={{
              fontSize: "12px",
            }}
          >
            <strong>핸드폰 번호:</strong>
          </Typography>
          <Typography
            sx={{
              borderBottom: "solid 1px",
              borderBottomColor: "darkgray",
            }}
          >
            {currentProfile.phone}
          </Typography>
          <Typography
            sx={{
              fontSize: "12px",
              padding: "1px 1px",
              marginTop: "3px",
            }}
          >
            <strong>소개 메시지:</strong>
          </Typography>
          <textarea
            value={currentProfile.message}
            readOnly
            rows={4}
            style={{ width: "100%", height: "120px", outline: "none" }}
          />
        </DialogContent>
      </Dialog>
    </div>
  );
}