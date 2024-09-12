import React, { useState } from "react";
import {
  Avatar,
  Card,
  CardContent,
  Typography,
  Badge,
  Chip,
  Dialog,
  DialogContent,
  Button,
} from "@mui/material";

// 프로필 카드 컴포넌트
function ProfileCard({ seatNumber, name, imgSrc, status, isSelf, openModal }) {
  const isOnline = status === "online";
  const showStatus = !isSelf; // 본인에게는 온라인/오프라인 상태 표시 안함

  return (
    <Card
      sx={{
        backgroundColor: isSelf, // 온라인: 흰색, 오프라인: 연한 회색
        borderRadius: "10px",
        boxShadow: "0 4px 12px rgba(0, 0, 0, 0.1)",
        width: "200px",
        textAlign: "center",
        padding: "0px",
        margin: "0px",
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
            padding: "5px 0px",
            marginLeft: "-16px",
            marginRight: "-16px",
            top: "-16px",
          }}
        >
          <Typography
            sx={{
              fontSize: "16px",
              fontWeight: "500",
              color: isOnline ? "#333" : "#b0b0b0", // 온라인: 진한 색, 오프라인: 회색
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
                padding: "0 8px",
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
              width: "60px",
              height: "60px",
              filter: isOnline ? "none" : "grayscale(100%)", // 오프라인: 흑백 필터
            }}
            src={imgSrc}
            alt={`${name}'s profile`}
            onClick={() => openModal(name)}
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

  // 가상 데이터 (25개의 자리)
  const profiles = Array.from({ length: 25 }, (_, i) => ({
    seatNumber: i + 1,
    name: `사용자 ${i + 1}`,
    status: i === 0 ? "self" : i % 2 === 0 ? "online" : "offline", // 본인은 첫 번째 자리, 나머지는 온라인/오프라인으로 구분
  }));

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
    <div style={{ display: "grid", gridTemplateColumns: "repeat(5, 1fr)", gap: "20px" }}>
      {profiles.map((profile, index) => (
        <ProfileCard
          key={index}
          seatNumber={profile.seatNumber}
          name={profile.name}
          imgSrc={profile.imgSrc}
          status={profile.status === "self" ? "self" : profile.status}
          isSelf={profile.status === "self"} // 본인 여부 확인
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
            style={{ width: "80px", height: "80px", marginLeft: "63px" }}
          />
          <Typography
            sx={{
              fontSize: "12px",
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
            style={{ width: "100%", outline: "none" }}
          />
        </DialogContent>
      </Dialog>
    </div>
  );
}
