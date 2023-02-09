// Import React
import React, { useState } from "react";
import PropTypes from "prop-types";

// Import mui/style
import BookmarkBorderIcon from "@mui/icons-material/BookmarkBorder";
// import BookmarkIcon from "@mui/icons-material/Bookmark";
import { Box } from "@mui/material";

// Import - custom
import ScrapButtonModal from "pages/home/buttons/scrapButtonModal";

// scrap Button 상태 - 활성화/비활성화
function ScrapButton({ feedType, targetId }) {
  // scrap Button Modal Set
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  // CARD Scrap Modal 창
  const handleToggle = (e) => {
    e.preventDefault();
    handleOpen(); // modal은 무조건 열리게
  };

  // BUNDLE Scrap function
  const handleBundleScrap = () => {
    console.log("번들 스크랩");
  };

  return (
    <Box className="icons-list">
      <ScrapButtonModal open={open} handleClose={handleClose} targetId={targetId} />
      {feedType === "CARD" ? (
        <BookmarkBorderIcon
          sx={{ cursor: "pointer", "&:hover": { transform: "scale(1.2)" } }}
          fontSize="large"
          transitio="1.2"
          className="button"
          onClick={handleToggle}
        />
      ) : (
        <BookmarkBorderIcon
          sx={{ cursor: "pointer", "&:hover": { transform: "scale(1.2)" } }}
          fontSize="large"
          transitio="1.2"
          className="button"
          onClick={handleBundleScrap}
        />
      )}
      {/* <BookmarkBorderIcon
        sx={{ cursor: "pointer", "&:hover": { transform: "scale(1.2)" } }}
        fontSize="large"
        transitio="1.2"
        className="button"
        onClick={handleToggle}
      />
      {value.isChecked ? (
        <BookmarkIcon
          sx={{
            color: "red",
            cursor: "pointer",
            transition: { transform: "300ms ease" },
          }}
          fontSize="large"
          className="button"
          onClick={handleToggle}
        />
      ) : (
        <BookmarkBorderIcon
          sx={{ cursor: "pointer", "&:hover": { transform: "scale(1.2)" } }}
          fontSize="large"
          transitio="1.2"
          className="button"
          onClick={handleToggle}
        />
      )}
      <Typography variant="caption" color="red">
        hello
      </Typography> */}
    </Box>
  );
}

ScrapButton.propTypes = {
  feedType: PropTypes.string.isRequired,
  targetId: PropTypes.number.isRequired,
};

export default ScrapButton;