package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;

public class StoryRoom extends AbstractRoom  {

    @Override
    public void printWelcomeMessage() {

        System.out.println("       *     \n" +
                "\t.\t \t\t\t\t\n" +
                "\t\t *          ^\n" +
                "\t\t+  *        ^\n" +
                "\t\t  .                      °              *\n" +
                "        +          .'.                      +         o\n" +
                "            '      |o|\n" +
                "                  .'o'.\t\t\to\n" +
                "                  |.-.|                  \n" +
                "     |            '   '  \t\t\t           ,\n" +
                "   - o -\t\t   ( )\t\t\t\t        \\  :  /\n" +
                "\t |\t\t\t\t)\t\t\t\t     `. __/ \\__ .'\n" +
                "\t\t\t\t   ( ) \t\t\t\t     _ _\\     /_ _\n" +
                "\t\t\t\t\t\t\t\t\t    \t/_   _\\\n" +
                "\t\t\t    ^-----------------        .'  \\ /  `.\n" +
                "\t*\t.\t    | Du bist hier. |\t\t    /  :  \\    \n" +
                "\t\t\t    ------------------\t\t\t   '\n" +
                "                   \t    o\t\t\t   \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                " o              +\n" +
                "\t\t\t\t\t\t\t .   *         °    \n" +
                "    ~+\n" +
                "\n" +
                "                                 +\n" +
                "        °           '                 |\n" +
                "               ()    .-.,=\"``\"=.    - o -\n" +
                "                     '=/_       \\     |\n" +
                "                  *   |  '=._    |\n" +
                "                       \\     `=./`,        '\n" +
                "                        '=.__.='`='      *\n" +
                "   +                         +\n" +
                "        O              '       .");

    }

    @Override
    public void enter()throws PlayerDeadException {

        System.out.println("");


    }
}



