import './App.css'

const tils = [
  { date: "09.18", level: "Lv.1", title: "두 수의 합이 target이 되는 쌍 찾기", tags: ["HashMap", "배열"] },
  { date: "09.16", level: "Lv.0", title: "문자열 뒤집기", tags: ["String", "투 포인터"] },
  { date: "09.14", level: "Lv.2", title: "섬의 개수 구하기", tags: ["DFS/BFS", "2차원 배열"] },
  { date: "09.11", level: "Lv.3", title: "최소 회의실 개수", tags: ["그리디", "정렬"] },
]

function App() {
  return (
    <div>
      <div className="filter-row">
        <span className="chip on">전체</span>
        <span className="chip">HashMap</span>
        <span className="chip">투 포인터</span>
        <span className="chip">DFS/BFS</span>
        <span className="chip">그리디</span>
      </div>

      <div>
        {tils.map((til) => (
          <div key={til.date} className="til-card">
            <div className="til-date">{til.date}</div>
            <div className="til-body">
              <div className="til-top">
                <span className="level-badge">{til.level}</span>
                <span className="til-title">{til.title}</span>
              </div>
              <div className="til-tags">
                {til.tags.map((tag) => (
                  <span className="tag" key={tag}>{tag}</span>
                ))}
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}

export default App