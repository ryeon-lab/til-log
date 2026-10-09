import './App.css';
import { useState } from 'react';

const initialTils = [
  {
    date: '09.18',
    level: 'Lv.1',
    title: '두 수의 합이 target이 되는 쌍 찾기',
    tags: ['HashMap', '배열'],
  },
  {
    date: '09.16',
    level: 'Lv.0',
    title: '문자열 뒤집기',
    tags: ['String', '투 포인터'],
  },
  {
    date: '09.14',
    level: 'Lv.2',
    title: '섬의 개수 구하기',
    tags: ['DFS/BFS', '2차원 배열'],
  },
  {
    date: '09.11',
    level: 'Lv.3',
    title: '최소 회의실 개수',
    tags: ['그리디', '정렬'],
  },
];

const chips = ['전체', 'HashMap', '투 포인터', 'DFS/BFS', '그리디'];
const levels = ['Lv.0', 'Lv.1', 'Lv.2', 'Lv.3'];

function App() {
  const [tils, setTils] = useState(initialTils);
  const [selected, setSelected] = useState('전체');
  const [screen, setScreen] = useState('list');
  const [title, setTitle] = useState('');
  const [url, setUrl] = useState('');
  const [level, setLevel] = useState('');
  const [solve, setSolve] = useState('');
  const [tagText, setTagText] = useState('');
  const filteredTils = tils.filter(
    (til) => selected === '전체' || til.tags.includes(selected),
  );

  const handleSave = () => {
    if (!title || !level) return; // 제목이나 레벨이 비어 있으면 저장 안 함

    const tags = tagText
      .split(',')
      .map((t) => t.trim())
      .filter((t) => t !== '');

    const today = new Date();
    const mm = String(today.getMonth() + 1).padStart(2, '0');
    const dd = String(today.getDate()).padStart(2, '0');

    const newTil = {
      date: `${mm}.${dd}`,
      level: level,
      title: title,
      url: url,
      solve: solve,
      tags: tags,
    };

    setTils([newTil, ...tils]); // 새 배열을 만들어서 교체

    setTitle(''); // 입력창 비우기
    setUrl('');
    setLevel('');
    setSolve('');
    setTagText('');
    setScreen('list'); // 목록 화면으로 돌아가기
  };

  return (
    <div>
      {screen === 'list' && (
        <button className="btn-write" onClick={() => setScreen('write')}>
          + 새 TIL
        </button>
      )}

      {screen === 'list' ? (
        <div>
          <div className="filter-row">
            {chips.map((chip) => (
              <span
                className={selected === chip ? 'chip on' : 'chip'}
                key={chip}
                onClick={() => setSelected(chip)}
              >
                {chip}
              </span>
            ))}
          </div>

          {filteredTils.map((til) => (
            <div key={til.date} className="til-card">
              <div className="til-date">{til.date}</div>
              <div className="til-body">
                <div className="til-top">
                  <span className="level-badge">{til.level}</span>
                  <span className="til-title">{til.title}</span>
                </div>
                <div className="til-tags">
                  {til.tags.map((tag) => (
                    <span className="tag" key={tag}>
                      {tag}
                    </span>
                  ))}
                </div>
              </div>
            </div>
          ))}
        </div>
      ) : (
        <div>
          <span className="back-link" onClick={() => setScreen('list')}>
            ← 목록으로
          </span>
          <div className="section-label">새 TIL 작성</div>

          <div className="form-grid">
            <div className="field">
              <label>문제 제목</label>
              <input
                type="text"
                placeholder="예: 두 수의 합 찾기"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
              />
            </div>

            <div className="field">
              <label>문제 링크</label>
              <input
                type="url"
                placeholder="https://programmers.co.kr/..."
                value={url}
                onChange={(e) => setUrl(e.target.value)}
              />
            </div>

            <div className="field">
              <label>레벨</label>
              <div className="filter-row">
                {levels.map((lv) => (
                  <span
                    key={lv}
                    className={level === lv ? 'chip on' : 'chip'}
                    onClick={() => setLevel(lv)}
                  >
                    {lv}
                  </span>
                ))}
              </div>
            </div>

            <div className="field">
              <label>배운 개념 (태그)</label>
              <input
                type="text"
                placeholder="HashMap, 배열 - 쉼표로 구분"
                value={tagText}
                onChange={(e) => setTagText(e.target.value)}
              />
            </div>

            <div className="field">
              <label>풀이 + 해설</label>
              <textarea
                placeholder="코드와 왜 이렇게 풀었는지를 함께 적어보세요"
                value={solve}
                onChange={(e) => setSolve(e.target.value)}
              />
            </div>

            <button className="save-btn" onClick={handleSave}>
              저장하기
            </button>
          </div>
        </div>
      )}
    </div>
  );
}

export default App;
