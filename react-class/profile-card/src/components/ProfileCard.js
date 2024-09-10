import React, { useState } from "react";
import rutanImage from "./image/rutan.jpg";
import {
  Avatar,
  Card,
  CardContent,
  Typography,
  Badge,
  Dialog,
  DialogTitle,
  DialogContent,
  Button,
} from "@mui/material";

// 프로필 카드 컴포넌트
function ProfileCard({ seatNumber, name, imgSrc, status, openModal }) {
  return (
    <Card style={{ width: "230px", height: "160px", textAlign: "center" }}>
      <CardContent>
        <Typography variant="h6">No. {seatNumber}</Typography>

        <Badge
          overlap="circle"
          anchorOrigin={{ vertical: "bottom", horizontal: "right" }}
          badgeContent={
            <span
              style={{
                backgroundColor: status === "online" ? "#28a745" : "#dc3545",
                borderRadius: "50%",
                width: "10px",
                height: "10px",
                display: "inline-block",
              }}
            />
          }
        >
          <Avatar
            src={imgSrc}
            alt={`${name}'s profile`}
            style={{ width: "50px", height: "50px" }}
            onClick={() => openModal(name)}
          />
        </Badge>

        <Typography variant="h6" onClick={() => openModal(name)}>
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
    <div style={{ display: "flex", gap: "20px", justifyContent: "center" }}>
      <ProfileCard
        seatNumber="1"
        name="강슬기"
        imgSrc={rutanImage}
        status="online"
        openModal={openProfileModal}
      />
      <ProfileCard
        seatNumber="2"
        name="권준성"
        imgSrc="https://via.placeholder.com/50"
        status="online"
        openModal={openProfileModal}
      />
      <ProfileCard
        seatNumber="3"
        name="최동인"
        imgSrc="https://via.placeholder.com/50"
        status="offline"
        openModal={openProfileModal}
      />

      {/* 모달 컴포넌트 */}
      <Dialog open={open} onClose={closeProfileModal}>
        <DialogTitle>프로필 상세 정보</DialogTitle>
        <DialogContent>
          <Avatar
            src="https://via.placeholder.com/100"
            alt={`${currentProfile.name}'s profile`}
            style={{ width: "100px", height: "100px" }}
          />
          <Typography variant="h6">
            <strong>이름:</strong> {currentProfile.name}
          </Typography>
          <Typography>
            <strong>이메일:</strong> {currentProfile.email}
          </Typography>
          <Typography>
            <strong>GitHub:</strong>{" "}
            <a
              href={currentProfile.github}
              target="_blank"
              rel="noopener noreferrer"
            >
              {currentProfile.github}
            </a>
          </Typography>
          <Typography>
            <strong>핸드폰 번호:</strong> {currentProfile.phone}
          </Typography>
          <Typography>
            <strong>소개 메시지:</strong>
          </Typography>
          <textarea
            value={currentProfile.message}
            readOnly
            rows={4}
            style={{ width: "100%" }}
          />
          <Button onClick={closeProfileModal}>닫기</Button>
        </DialogContent>
      </Dialog>
    </div>
  );
}
