if has("gui_running")
  if has("gui_gtk2")
    set guifont=Inconsolata\ 12
  elseif has("gui_macvim")
    set guifont=Menlo\ Regular:h14
  elseif has("gui_win32")
    set guifont=Consolas:h10:cANSI
  endif
endif

syntax on
set background=light
colorscheme donbass

set lines=55 columns=90

winpos 630 150

set backspace=indent,eol,start